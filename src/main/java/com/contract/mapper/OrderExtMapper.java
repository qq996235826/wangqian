package com.contract.mapper;

import com.contract.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderExtMapper
{

    List<Order> orderFuzzySearch(@Param("status") int status, @Param("item") String item, @Param("company") String company, @Param("info") String info,@Param("origin") Integer origin);
    List<Order> orderFuzzySearchWithoutStatus(@Param("item") String item, @Param("company") String company, @Param("info") String info,@Param("origin") Integer origin);
}
