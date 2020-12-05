package com.contract.service;

import com.contract.mapper.ContractTemplateMapper;
import com.contract.mapper.OrderMapper;
import com.contract.mapper.SupplierMapper;
import com.contract.model.*;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
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
    public Map getOrders()
    {
        //创建map用于返回
        Map result=new HashMap<>();
        //List放在result里
        List<Map> rows=new ArrayList<>();
        //从数据获得数据
        OrderExample example=new OrderExample();
        example.createCriteria().andIdIsNotNull().andStatusNotEqualTo(-1);
        List<Order> orders=orderMapper.selectByExample(example);
        //把数据填入map,每个Order都是一个map,把每个map存入list中
        for (int a=0;a<orders.size();a++)
        {
            //获得供货人信息
            Supplier supplier=supplierMapper.selectByPrimaryKey(orders.get(a).getSupplierId());
            Map map=new HashMap();
            //合同id
            map.put("id",orders.get(a).getId());
            //使用模板id
            map.put("templateId",orders.get(a).getTemplateId());
            //合同创建时间
            map.put("createTime",sdf.format(orders.get(a).getCreateTime()));
            //货物名称
            map.put("itemName",orders.get(a).getItemName());
            //价格
            map.put("price",orders.get(a).getPrice());
            //业务编码
            map.put("orderNum",orders.get(a).getOrderNum());
            //甲方名字
            map.put("companyName",orders.get(a).getCompanyName());
            //供货人id
            map.put("supplierId",orders.get(a).getSupplierId());
            //供货人名字
            map.put("supplierName",supplier.getName());
            //供货人身份证号
            map.put("supplierIdNum",supplier.getIdNum());
            //开户行
            map.put("bankName",orders.get(a).getBankName());
            //支行
            map.put("branchBankName",orders.get(a).getBranchBankName());
            //银行卡号
            map.put("bankNum",orders.get(a).getBankNum());
            //审核状态
            //-1--未签名 0--已提交(签名,没审核),10--审核通过(有了签名,有审核,没盖章),90--已生效(上传了盖章文件),20--已失效
            if(orders.get(a).getStatus()==0)
            {
                map.put("status","已提交");
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
            //记录更新日期
            map.put("updateTime",sdf.format(orders.get(a).getUpdateTime()));
            //pdf路径
            map.put("pdfUrl",orders.get(a).getPdfPath());
            rows.add(map);
        }
        //设置数据行数
        result.put("total",rows.size());
        //把list放入Map中
        result.put("rows",rows);
        return result;
    }


    /**
     * 获得所有的供货人
     * @return Map
     */
    public Map getSuppliers()
    {
        //创建map用于返回
        Map result=new HashMap<>();
        //List放在result里
        List<Map> rows=new ArrayList<>();
        //从数据获得数据
        SupplierExample example=new SupplierExample();
        example.createCriteria().andIdIsNotNull();
        List<Supplier> supplierList=supplierMapper.selectByExample(example);
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
            rows.add(map);
        }
        //设置数据行数
        result.put("total",rows.size());
        //把list放入Map中
        result.put("rows",rows);
        return result;
    }

    public Map getOrdersInfo() {
        //创建map用于返回
        Map result=new HashMap<>();
        //List放在result里
        List<Map> rows=new ArrayList<>();
        //从数据获得数据
        OrderExample example=new OrderExample();
        example.createCriteria().andIdIsNotNull().andStatusNotEqualTo(-1);
        List<Order> orders=orderMapper.selectByExample(example);
        //把数据填入map,每个Order都是一个map,把每个map存入list中
        for (int a=0;a<orders.size();a++)
        {
            //获得供货人信息
            Supplier supplier=supplierMapper.selectByPrimaryKey(orders.get(a).getSupplierId());

            Map map=new HashMap();
            //合同id
            map.put("id",orders.get(a).getId());
            //使用模板id
            map.put("templateId",orders.get(a).getTemplateId());
            //合同创建时间
            map.put("createTime",sdf.format(orders.get(a).getCreateTime()));
            //货物名称
            map.put("itemName",orders.get(a).getItemName());
            //价格
            map.put("price",orders.get(a).getPrice());
            //业务编码
            map.put("orderNum",orders.get(a).getOrderNum());
            //甲方名字
            map.put("companyName",orders.get(a).getCompanyName());
            //供货人id
            map.put("supplierId",orders.get(a).getSupplierId());
            //供货人名字
            map.put("supplierName",supplier.getName());
            //供货人身份证号
            map.put("supplierIdNum",supplier.getIdNum());
            //开户行
            map.put("bankName",orders.get(a).getBankName());
            //支行
            map.put("branchBankName",orders.get(a).getBranchBankName());
            //银行卡号
            map.put("bankNum",orders.get(a).getBankNum());
            //审核状态
            //'checking':"审核中","checkPass":"审核通过","checkFail":"审核未通过"
            if(orders.get(a).getStatus()==0)
            {
                map.put("status","草拟");
            }
            else if(orders.get(a).getStatus()==10)
            {
                map.put("status","待盖章");
            }
            else if(orders.get(a).getStatus()==20)
            {
                map.put("status","审核未通过");
            }
            else if(orders.get(a).getStatus()==90)
            {
                map.put("status","已盖章");
            }

            map.put("updateTime",sdf.format(orders.get(a).getUpdateTime()));
            rows.add(map);
        }
        //设置数据行数
        result.put("total",rows.size());
        //把list放入Map中
        result.put("rows",rows);
        return result;
    }

    public Map getTemplates() {
        //创建map用于返回
        Map result=new HashMap<>();
        //List放在result里
        List<Map> rows=new ArrayList<>();
        //从数据获得数据
        ContractTemplateExample example=new ContractTemplateExample();
        example.createCriteria().andIdIsNotNull();
        List<ContractTemplate> templates= contractTemplateMapper.selectByExample(example);
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
        //设置数据行数
        result.put("total",rows.size());
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



}
