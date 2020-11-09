package com.contract.mapper;

import com.contract.model.Admin;
import com.contract.model.AdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExampleWithRowbounds(AdminExample example, RowBounds rowBounds);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}