package com.contract.mapper;

import com.contract.model.Company;
import com.contract.model.CompanyExample;
import com.contract.model.CompanyKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CompanyMapper {
    long countByExample(CompanyExample example);

    int deleteByExample(CompanyExample example);

    int deleteByPrimaryKey(CompanyKey key);

    int insert(Company record);

    int insertSelective(Company record);

    List<Company> selectByExampleWithRowbounds(CompanyExample example, RowBounds rowBounds);

    List<Company> selectByExample(CompanyExample example);

    Company selectByPrimaryKey(CompanyKey key);

    int updateByExampleSelective(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByExample(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
}