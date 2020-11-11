package com.contract.service;

import com.contract.mapper.OrderMapper;
import com.contract.model.Order;
import com.contract.model.OrderExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    public Map getOrders()
    {
        //创建map用于返回
        Map result=new HashMap<>();
        List<Map> rows=new ArrayList<>();
        //获得数据
        OrderExample example=new OrderExample();
        example.createCriteria().andIdIsNotNull();
        List<Order> orders=orderMapper.selectByExample(example);
        //把数据填入map
        for (int a=0;a<orders.size();a++)
        {
            Map map=new HashMap();
            map.put("id",orders.get(a).getId());
            map.put("templateId",orders.get(a).getTemplateId());
            map.put("supplierId",orders.get(a).getSupplierId());
            map.put("createTime",orders.get(a).getCreateTime());
            map.put("itemName",orders.get(a).getItemName());
            map.put("orderNum",orders.get(a).getOrderNum());
            map.put("status",orders.get(a).getStatus());
            map.put("updateTime",orders.get(a).getUpdateTime());
            map.put("path",orders.get(a).getPath());
            rows.add(map);
        }
        result.put("total",rows.size());
        result.put("rows",rows);
        return result;
    }
}
