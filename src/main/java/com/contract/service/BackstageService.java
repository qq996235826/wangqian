package com.contract.service;

import com.contract.dto.OrderDTO;
import com.contract.exception.CustomizeErrorCode;
import com.contract.exception.CustomizeException;
import com.contract.mapper.ContractTemplateMapper;
import com.contract.mapper.OrderMapper;
import com.contract.mapper.SupplierMapper;
import com.contract.model.*;
import com.qiniu.util.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author deng
 * @version 1.0
 * @description 用于给网页端服务
 * @date 2020/11/11 22:18
 */
@Service
public class BackstageService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private SupplierMapper supplierMapper;

    @Resource
    private ContractTemplateMapper contractTemplateMapper;

    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 负责给审核页面的表格返回数据
     * @return Map
     */
    public Map getOrders(HttpServletRequest request)
    {
        String companyCode=request.getParameter("companyCode");
        Integer page=Integer.valueOf(request.getParameter("page"));
        Integer row=Integer.valueOf(request.getParameter("rows"));
        //划分线上
        Integer origin=Integer.valueOf(request.getParameter("origin"));
        if(origin!=0&&origin!=1)
        {
            origin=1;
        }
        //创建map用于返回
        Map result=new HashMap<>();
        //List放在result里
        List<Map> rows=new ArrayList<>();
        //从数据获得数据
        OrderExample example=new OrderExample();
        example.setOrderByClause(" id desc");
        if(StringUtils.isNullOrEmpty(companyCode))
        {
            example.createCriteria().andStatusNotEqualTo(-1).andStatusNotEqualTo(20).andOriginEqualTo(origin);
        }
        else
        {
            example.createCriteria().andStatusNotEqualTo(-1).andStatusNotEqualTo(20).andOriginEqualTo(origin).andCompanyCodeEqualTo(companyCode);
        }
        //总数据
        Long totalCount = orderMapper.countByExample(example);
        result.put("total",totalCount);
        //分页
        RowBounds rowBounds=new RowBounds((page-1)*row,row);
        List<Order> orders=orderMapper.selectByExampleWithRowbounds(example,rowBounds);
        //把数据填入map,每个Order都是一个map,把每个map存入list中
        for (int a=0;a<orders.size();a++)
        {
            try
            {
                //获得供货人信息
                Supplier supplier=supplierMapper.selectByPrimaryKey(orders.get(a).getSupplierId());
                Map map=new HashMap();
                //合同id
                map.put("id",orders.get(a).getId());
//                //使用模板id
//                map.put("templateId",orders.get(a).getTemplateId());
                //合同创建时间
                map.put("createTime",sdf.format(orders.get(a).getCreateTime()));
                //货物名称
                map.put("itemName",orders.get(a).getItemName());
                //价格
                map.put("price",orders.get(a).getPrice());
                //重量
                map.put("weight",orders.get(a).getWeight());
                //业务编码
                map.put("orderNum",orders.get(a).getOrderNum());
                //甲方名字
                map.put("companyName",orders.get(a).getCompanyName());
                //供货人id
                map.put("supplierId",orders.get(a).getSupplierId());
                //供货人名字
                map.put("supplierName",orders.get(a).getSupplierName());
                //供货人身份证号
                map.put("supplierIdNum",orders.get(a).getSupplierIdNum());
                //开户行
                map.put("bankName",orders.get(a).getBankName());
                //支行
                map.put("branchBankName",orders.get(a).getBranchBankName());
                //银行卡号
                map.put("bankNum",orders.get(a).getBankNum());
                //审核状态
                //-1--未签名 0--待审核(签名,没审核),10--审核通过(有了签名,有审核,没盖章),90--已生效(上传了盖章文件),20--已失效
                if(orders.get(a).getStatus()==0)
                {
                    map.put("status","待审核");
                }
                else if(orders.get(a).getStatus()==10)
                {
                    map.put("status","待盖章");
                }
                else if(orders.get(a).getStatus()==20)
                {
                    map.put("status","已失效");
                }
                else if(orders.get(a).getStatus()==90)
                {
                    map.put("status","已生效");
                }
                //生效日期
                map.put("startDate",orders.get(a).getStartDate());
                //截止日期
                map.put("endDate",orders.get(a).getEndDate());
//                //记录更新日期
//                map.put("updateTime",sdf.format(orders.get(a).getUpdateTime()));
//                //pdf路径
//                map.put("pdfUrl",orders.get(a).getPdfPath());
                rows.add(map);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        //把list放入Map中
        result.put("rows",rows);
        return result;
    }



    /**
     * 获得所有的供货人
     * @return Map
     */
    public Map getSuppliers(HttpServletRequest request)
    {
        Integer page=Integer.valueOf(request.getParameter("page"));
        Integer row=Integer.valueOf(request.getParameter("rows"));
        //创建map用于返回
        Map result=new HashMap<>();
        //List放在result里
        List<Map> rows=new ArrayList<>();
        //从数据获得数据
        SupplierExample example=new SupplierExample();
        example.setOrderByClause(" id desc");
        example.createCriteria().andIdIsNotNull();
        //总数据
        Long totalCount = supplierMapper.countByExample(example);
        result.put("total",totalCount);
        //分页
        RowBounds rowBounds=new RowBounds((page-1)*row,row);
        List<Supplier> supplierList=supplierMapper.selectByExampleWithRowbounds(example,rowBounds);
        //把数据填入map,每个supplier都是一个map,把每个map存入list中
        for (int a=0;a<supplierList.size();a++)
        {
            Map map=new HashMap();
            map.put("id",supplierList.get(a).getId());
            map.put("idNum",supplierList.get(a).getIdNum());
            map.put("password",supplierList.get(a).getPassword());
            map.put("phoneNum",supplierList.get(a).getPhoneNum());
            map.put("name",supplierList.get(a).getName());
            map.put("homeAddress",supplierList.get(a).getHomeAddress());
            map.put("birth",supplierList.get(a).getBirth());
            map.put("agencies",supplierList.get(a).getAgencies());
            map.put("sex",supplierList.get(a).getSex());
            map.put("ethnic",supplierList.get(a).getEthnic());
            map.put("updateTime",sdf.format(supplierList.get(a).getUpdateTime()));
            if(supplierList.get(a).getStstus()==4)
            {
                map.put("status","停用");
            }
            else
            {
                map.put("status","启用");
            }
            rows.add(map);
        }
        //把list放入Map中
        result.put("rows",rows);
        return result;
    }

    public Map getOrdersInfo(HttpServletRequest request) {
        //分页
        Integer page=Integer.valueOf(request.getParameter("page"));
        Integer row=Integer.valueOf(request.getParameter("rows"));
        //创建map用于返回
        Map result=new HashMap<>();
        //List放在result里
        List<Map> rows=new ArrayList<>();
        //从数据获得数据
        OrderExample example=new OrderExample();
        example.setOrderByClause(" id desc");
        String companyCode=request.getParameter("companyCode");
        if(companyCode==null)
        {
            example.createCriteria().andIdIsNotNull().andStatusNotEqualTo(-1);
        }
        else
        {
            example.createCriteria().andIdIsNotNull().andStatusNotEqualTo(-1).andCompanyCodeEqualTo(companyCode);
        }
        //总数据
        Long totalCount = orderMapper.countByExample(example);
        result.put("total",totalCount);
        //分页
        RowBounds rowBounds=new RowBounds((page-1)*row,row);
        List<Order> orders=orderMapper.selectByExampleWithRowbounds(example,rowBounds);
        //把数据填入map,每个Order都是一个map,把每个map存入list中
        for (int a=0;a<orders.size();a++)
        {

            //获得供货人信息
            Supplier supplier = supplierMapper.selectByPrimaryKey(orders.get(a).getSupplierId());

            Map map = new HashMap();
            //合同id
            map.put("id", orders.get(a).getId());
            //合同创建时间
            map.put("createTime", sdf.format(orders.get(a).getCreateTime()));
            //货物名称
            map.put("itemName", orders.get(a).getItemName());
            //价格
            map.put("price", orders.get(a).getPrice());
            //业务编码
            map.put("orderNum", orders.get(a).getOrderNum());
            //甲方名字
            map.put("companyName", orders.get(a).getCompanyName());
            //供货人id
            map.put("supplierId", orders.get(a).getSupplierId());
            //重量
            map.put("weight",orders.get(a).getWeight());
            //生效日期
            map.put("startDate",orders.get(a).getStartDate());
            //截止日期
            map.put("endDate",orders.get(a).getEndDate());

            //供货人名字
            if (orders.get(a).getSupplierName() == null)
            {
                map.put("supplierName", "找不到供货人");
            }
            else
            {
                map.put("supplierName", orders.get(a).getSupplierName());
            }
            //供货人身份证号
            if (orders.get(a).getSupplierIdNum() == null)
            {
                map.put("supplierIdNum", "找不到供货人");
            }
            else
            {
                map.put("supplierIdNum", orders.get(a).getSupplierIdNum());
            }
            //开户行
            map.put("bankName", orders.get(a).getBankName());
            //支行
            map.put("branchBankName", orders.get(a).getBranchBankName());
            //银行卡号
            map.put("bankNum", orders.get(a).getBankNum());
            //审核状态
            //'checking':"审核中","checkPass":"审核通过","checkFail":"审核未通过"
            if (orders.get(a).getStatus() == 0)
            {
                map.put("status", "待审核");
            }
            else if (orders.get(a).getStatus() == 10)
            {
                map.put("status", "待盖章");
            }
            else if (orders.get(a).getStatus() == 20)
            {
                map.put("status", "已失效");
            }
            else if (orders.get(a).getStatus() == 90)
            {
                map.put("status", "已生效");
            }
            //线上线下
            if (orders.get(a).getOrigin()==null||orders.get(a).getOrigin()!=1)
            {
                map.put("origin", "线上");
            }
            else
            {
                map.put("origin", "线下");
            }

            map.put("updateTime",sdf.format(orders.get(a).getUpdateTime()));
            rows.add(map);
        }
        //把list放入Map中
        result.put("rows",rows);
        return result;
    }

    public Map getTemplates(HttpServletRequest request) {
        Integer page=Integer.valueOf(request.getParameter("page"));
        Integer row=Integer.valueOf(request.getParameter("rows"));
        //创建map用于返回
        Map result=new HashMap<>();
        //List放在result里
        List<Map> rows=new ArrayList<>();
        //从数据获得数据
        ContractTemplateExample example=new ContractTemplateExample();
        example.createCriteria().andIdIsNotNull();
        //总数据
        Long totalCount = contractTemplateMapper.countByExample(example);
        result.put("total",totalCount);
        //分页
        RowBounds rowBounds=new RowBounds((page-1)*row,row);
        List<ContractTemplate> templates= contractTemplateMapper.selectByExampleWithRowbounds(example,rowBounds);
        //把数据填入map,每个Order都是一个map,把每个map存入list中
        for (int a=0;a<templates.size();a++)
        {
            Map map=new HashMap();
            map.put("id",templates.get(a).getId());
            map.put("path",templates.get(a).getPath());
            map.put("createTime",sdf.format(templates.get(a).getCreateTime()));
            map.put("updateTime",sdf.format(templates.get(a).getUpdateTime()));
            map.put("isUsing",templates.get(a).getIsUsing()?"是":"否");
            map.put("versionNum",templates.get(a).getId());
            map.put("note",templates.get(a).getNote());
            map.put("ossUrl",templates.get(a).getOssUrl());
            map.put("jpgOssUrl",templates.get(a).getJpgOssUrl());
            rows.add(map);
        }
        //把list放入Map中
        result.put("rows",rows);
        return result;
    }

    /**
     * 获得合同的数量
     * @return
     */
    public Long getCountOfOrders() {
        OrderExample example=new OrderExample();
        example.createCriteria().andIdIsNotNull();
        return orderMapper.countByExample(example);
    }


    public List<Map<String, Object>> getContractStatus()
    {
        List<Map<String, Object>> statusList=new ArrayList<>();
        Map<String, Object> status1=new HashMap<>();
        Map<String, Object> status2=new HashMap<>();
        Map<String, Object> status3=new HashMap<>();
        Map<String, Object> status4=new HashMap<>();
        Map<String, Object> status5=new HashMap<>();
        Map<String, Object> status6=new HashMap<>();
        status1.put("code",-1);
        status1.put("status","未签名");
        status2.put("code",0);
        status2.put("status","待审核");
        status3.put("code",10);
        status3.put("status","待盖章");
        status4.put("code",20);
        status4.put("status","已失效");
        status5.put("code",90);
        status5.put("status","已生效");
        status6.put("code",-2);
        status6.put("status","全部");
        status6.put("selected","true");
        statusList.add(status1);
        statusList.add(status2);
        statusList.add(status3);
        statusList.add(status4);
        statusList.add(status5);
        statusList.add(status6);
        return statusList;
    }

    public List<Map<String, Object>> getContractStatusNew()
    {
        List<Map<String, Object>> statusList=new ArrayList<>();
        Map<String, Object> status1=new HashMap<>();
        Map<String, Object> status2=new HashMap<>();
        Map<String, Object> status3=new HashMap<>();
        Map<String, Object> status4=new HashMap<>();
        Map<String, Object> status5=new HashMap<>();
        status1.put("code",-1);
        status1.put("status","未签名");
        status2.put("code",1);
        status2.put("status","待审核");
        status3.put("code",10);
        status3.put("status","待盖章");
        status4.put("code",20);
        status4.put("status","已失效");
        status5.put("code",90);
        status5.put("status","已生效");
        statusList.add(status1);
        statusList.add(status2);
        statusList.add(status3);
        statusList.add(status4);
        statusList.add(status5);
        return statusList;
    }


    public List<Map<String, Object>> getName(String q)
    {
        SupplierExample example=new SupplierExample();
        example.createCriteria().andNameLike(q);
        List<Supplier> suppliers=supplierMapper.selectByExample(example);
        List<Map<String,Object>> supplierList=new ArrayList<>();
        for(int a=0;a<suppliers.size();a++)
        {
            Map<String,Object> map=new HashMap<>();
            map.put("id",suppliers.get(a).getId());
            map.put("name",suppliers.get(a).getName());
            supplierList.add(map);
        }
        return supplierList;
    }

    public OrderDTO getOrderInfo(HttpServletRequest request)
    {
        String id=request.getParameter("id");
        Order order=orderMapper.selectByPrimaryKey(Long.valueOf(id));
        if(order!=null)
        {
            return new OrderDTO(order);
        }
        else
        {
            throw new CustomizeException(CustomizeErrorCode.ORDER_ID_WRONG);
        }
    }

    public List<Map<String, Object>> SuppliersIdNum()
    {
        SupplierExample example = new SupplierExample();
        example.createCriteria().andIdNumIsNotNull();
        List<Supplier> suppliers = supplierMapper.selectByExample(example);
        List<Map<String, Object>> supplierList = new ArrayList<>();
        for (int a = 0; a < suppliers.size(); a++)
        {
            Map<String, Object> map = new HashMap<>();
            map.put("code", suppliers.get(a).getIdNum());
            map.put("name", suppliers.get(a).getIdNum());
            supplierList.add(map);
        }
        return supplierList;
    }
}
