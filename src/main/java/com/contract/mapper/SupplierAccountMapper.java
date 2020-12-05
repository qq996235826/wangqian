package com.contract.mapper;

import com.contract.model.SupplierAccount;
import com.contract.model.SupplierAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SupplierAccountMapper {
    long countByExample(SupplierAccountExample example);

    int deleteByExample(SupplierAccountExample example);

    int deleteByPrimaryKey(Integer ID);

    int insert(SupplierAccount record);

    int insertSelective(SupplierAccount record);

    List<SupplierAccount> selectByExampleWithRowbounds(SupplierAccountExample example, RowBounds rowBounds);

    List<SupplierAccount> selectByExample(SupplierAccountExample example);

    SupplierAccount selectByPrimaryKey(Integer ID);

    int updateByExampleSelective(@Param("record") SupplierAccount record, @Param("example") SupplierAccountExample example);

    int updateByExample(@Param("record") SupplierAccount record, @Param("example") SupplierAccountExample example);

    int updateByPrimaryKeySelective(SupplierAccount record);

    int updateByPrimaryKey(SupplierAccount record);
}