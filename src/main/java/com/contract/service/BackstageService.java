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
            map.put("createTime",orders.get(a).getCreateTime());
            map.put("itemName",orders.get(a).getItemName());
            map.put("orderNum",orders.get(a).getOrderNum());
            map.put("status",orders.get(a).getStatus());
            map.put("updateTime",orders.get(a).getUpdateTime());
            map.put("path",orders.get(a).getPath());
            rows.add(map);
        }
        //设置数据行数
        result.put("total",rows.size());
        //把list放入Map中
        result.put("rows",rows);
        return result;
    }
}
