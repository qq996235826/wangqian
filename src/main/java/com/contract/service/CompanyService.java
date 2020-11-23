package com.contract.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.contract.Utils.HttpUtils;
import com.contract.exception.CustomizeErrorCode;
import com.contract.exception.CustomizeException;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author deng
 * @version 1.0
 * @description 公司的Service
 * @date 2020/11/23 22:00
 */
@Service
public class CompanyService {

    private OkHttpClient client = new OkHttpClient();


    /**
     *
     * @return
     */
    public JSONArray getCompany() {
        try {
            Response response= HttpUtils.get("http://121.199.77.75:8080/EPServer//servlet/siter/FindMyCompany");
            String StringTemp = response.body().string();
            JSONObject jsonObjectTemp = (JSONObject) JSONObject.parse(StringTemp);
            JSONArray jsonArray = (JSONArray) jsonObjectTemp.get("rows");
            return jsonArray;
        } catch (IOException e) {
            throw new CustomizeException(CustomizeErrorCode.COMPANY_WRONG);
        }
    }
}
