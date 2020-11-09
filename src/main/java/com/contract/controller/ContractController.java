package com.contract.controller;


import com.contract.dto.ContractInfoDTO;
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
     * 生成新合同
     * @param
     * @return 合同存储路径
     */
    @ResponseBody
    @GetMapping("/getTem")
    public ResultDTO getContractTem() {
        return ResultDTO.okOf(contractService.getTemplateUrl());
    }

    /**
     * 上传新的合同接口
     * @param contractInfoDTO
     * @return 合同模板存储路径
     */
    @ResponseBody
    @PostMapping("/getContract")
    public ResultDTO getContract(@RequestBody ContractInfoDTO contractInfoDTO) {
        return ResultDTO.okOf(contractService.getContract(contractInfoDTO));
    }


}
