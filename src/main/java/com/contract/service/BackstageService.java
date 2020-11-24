package com.contract.service;

import com.contract.mapper.OrderMapper;
import com.contract.mapper.SupplierMapper;
import com.contract.model.Order;
import com.contract.model.OrderExample;
import com.contract.model.Supplier;
import com.contract.model.SupplierExample;
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
        example.createCriteria().andIdIsNotNull();
        List<Order> orders=orderMapper.selectByExample(example);
        //把数据填入map,每个Order都是一个map,把每个map存入list中
        for (int a=0;a<orders.size();a++)
        {
            Map map=new HashMap();
            map.put("id",orders.get(a).getId());
            map.put("templateId",orders.get(a).getTemplateId());
            map.put("supplierId",orders.get(a).getSupplierId());
            map.put("createTime",sdf.format(orders.get(a).getCreateTime()));
            map.put("itemName",orders.get(a).getItemName());
            map.put("orderNum",orders.get(a).getOrderNum());
            //审核状态
            //状态,  0--草拟,10--待盖章,20--打回，需用户修改,90--已盖章
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
            map.put("path",orders.get(a).getPath());
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
        example.createCriteria().andIdIsNotNull();
        List<Order> orders=orderMapper.selectByExample(example);
        //把数据填入map,每个Order都是一个map,把每个map存入list中
        for (int a=0;a<orders.size();a++)
        {
            Map map=new HashMap();
            map.put("id",orders.get(a).getId());
            map.put("templateId",orders.get(a).getTemplateId());
            map.put("supplierId",orders.get(a).getSupplierId());
            map.put("createTime",sdf.format(orders.get(a).getCreateTime()));
            map.put("itemName",orders.get(a).getItemName());
            map.put("companyName",orders.get(a).getCompanyName());
            map.put("bankName",orders.get(a).getBankName());
            map.put("bankNum",orders.get(a).getBankNum());
            map.put("price",orders.get(a).getPrice());
            map.put("orderNum",orders.get(a).getOrderNum());
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
}
