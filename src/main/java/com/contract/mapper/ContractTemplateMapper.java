package com.contract.mapper;

import com.contract.model.ContractTemplate;
import com.contract.model.ContractTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ContractTemplateMapper {
    long countByExample(ContractTemplateExample example);

    int deleteByExample(ContractTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContractTemplate record);

    int insertSelective(ContractTemplate record);

    List<ContractTemplate> selectByExampleWithRowbounds(ContractTemplateExample example, RowBounds rowBounds);

    List<ContractTemplate> selectByExample(ContractTemplateExample example);

    ContractTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContractTemplate record, @Param("example") ContractTemplateExample example);

    int updateByExample(@Param("record") ContractTemplate record, @Param("example") ContractTemplateExample example);

    int updateByPrimaryKeySelective(ContractTemplate record);

    int updateByPrimaryKey(ContractTemplate record);
}