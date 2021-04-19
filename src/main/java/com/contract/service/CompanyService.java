package com.contract.service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.contract.Utils.HttpUtils;
import com.contract.exception.CustomizeErrorCode;
import com.contract.exception.CustomizeException;
import com.contract.mapper.CompanyMapper;
import com.contract.model.Company;
import com.contract.model.CompanyExample;
import com.qiniu.util.StringUtils;
import okhttp3.Response;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author deng
 * @version 1.0
 * @description 公司的Service
 * @date 2020/11/23 22:00
 */
@Service
public class CompanyService
{

    @Resource
    private CompanyMapper companyMapper;

    /**
     * @return
     */
    public JSONArray getCompany()
    {
        try
        {
            Response response = HttpUtils.get("http://121.199.77.75:8080/EPServer//servlet/siter/FindMyCompany");
            String StringTemp = response.body().string();
            JSONObject jsonObjectTemp = (JSONObject) JSONObject.parse(StringTemp);
            JSONArray jsonArray = (JSONArray) jsonObjectTemp.get("rows");
            return jsonArray;
        }
        catch (IOException e)
        {
            throw new CustomizeException(CustomizeErrorCode.COMPANY_WRONG);
        }
    }

    public List<Map<String, Object>> getCompanies(HttpServletRequest request)
    {
        String companyCode=request.getParameter("companyCode");
        CompanyExample example = new CompanyExample();
        if(StringUtils.isNullOrEmpty(companyCode))
        {
            example.createCriteria().andIDIsNotNull();
        }
        else
        {
            example.createCriteria().andIDIsNotNull().andCodeEqualTo(companyCode);
        }
        List<Company> companies = companyMapper.selectByExample(example);
        List<Map<String, Object>> companyList = new ArrayList<>();
        for (int a = 0; a < companies.size(); a++)
        {
            Map<String, Object> map = new HashMap<>();
            map.put("code", companies.get(a).getCode());
            map.put("name", companies.get(a).getName());
            companyList.add(map);
        }
        return companyList;
    }
}
