package com.contract.controller;

import com.contract.dto.ResultDTO;
import com.contract.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;

/**
 * @author deng
 * @version 1.0
 * @description 公司的Controller
 * @date 2020/11/23 21:58
 */
@Controller
@RequestMapping("/company")
public class CompanyController {
    @Resource
    CompanyService companyService;

    /**
     * 获得公司列表
     * @return
     */
    @PostMapping("/getCompany")
    @ResponseBody
    public ResultDTO getCompany()
    {
        return ResultDTO.okOf(companyService.getCompany());
    }

}
