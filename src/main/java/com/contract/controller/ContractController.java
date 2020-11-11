package com.contract.controller;


import com.contract.dto.ResultDTO;
import com.contract.service.ContractService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;


/**
 * @author deng
 * @version 1.0
 * @description 负责合同模板处理的controller
 * @date 2020/11/1 15:33
 */
@RestController
@RequestMapping("/contract")
public class ContractController {

    @Resource
    private ContractService contractService;


    /**
     * 上传新的合同接口
     * @param upload
     * @return 合同模板存储路径
     */
    @ResponseBody
    @PostMapping("/uploadContract")
    public ResultDTO uploadContract(MultipartFile upload) {
        return ResultDTO.okOf(contractService.uploadContract(upload));
    }

    /**
     * 获得模板合同
     * @param
     * @return 合同存储路径
     */
    @ResponseBody
    @GetMapping("/getTem")
    public ResultDTO getContractTem() {
        return ResultDTO.okOf(contractService.getTemplateUrl());
    }

    /**
     * 获得新的合同
     * @param  file,  phoneNum, item, price
     * @return 合同存储路径
     */
    @ResponseBody
    @PostMapping("/getContract")
    public ResultDTO getContract(MultipartFile file, String phoneNum,String item,String price) {
        return ResultDTO.okOf(contractService.getContract(file,phoneNum,item,price));
    }


}
