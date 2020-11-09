package com.contract.mapper;

import com.contract.model.Supplier;
import com.contract.model.SupplierExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SupplierMapper {
    long countByExample(SupplierExample example);

    int deleteByExample(SupplierExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    List<Supplier> selectByExampleWithRowbounds(SupplierExample example, RowBounds rowBounds);

    List<Supplier> selectByExample(SupplierExample example);

    Supplier selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Supplier record, @Param("example") SupplierExample example);

    int updateByExample(@Param("record") Supplier record, @Param("example") SupplierExample example);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);
}