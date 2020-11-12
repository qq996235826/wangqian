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
    @PostMapping("/uploadContractTemplate")
    public ResultDTO uploadContract(MultipartFile upload) {
        return ResultDTO.okOf(contractService.uploadContractTemplate(upload));
    }

    /**
     * 上传模板合同图片给前端客户浏览
     * @param file
     * @return 图片下载链接
     */
    @ResponseBody
    @PostMapping("/uploadContractTemplateImage")
    public ResultDTO uploadContractTemplateImage(MultipartFile file) {
        return ResultDTO.okOf(contractService.uploadContractTemplateImage(file));
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
     * 获得新的合成好的合同
     * @param  file,  phoneNum, item, price
     * @return 合同存储路径
     */
    @ResponseBody
    @PostMapping("/getContract")
    public ResultDTO getContract(MultipartFile file, String phoneNum,String item,String price) {
        return ResultDTO.okOf(contractService.getContract(file,phoneNum,item,price));
    }

    /**
     * 获得最新模板图片
     * @return 图片下载链接
     */
    @ResponseBody
    @PostMapping("/getContractTemplateImage")
    public ResultDTO getContractTemplateImage()
    {
        return ResultDTO.okOf(contractService.getContractTemplateImage());
    }

    /**
     * 指定合同审核状态
     * @return 状态
     */
    @ResponseBody
    @PostMapping("/getOrderStatus")
    public ResultDTO getOrderStatus(String phoneNum)
    {
        return ResultDTO.okOf(contractService.getOrderStatus(phoneNum));
    }





}
