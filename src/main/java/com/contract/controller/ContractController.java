package com.contract.controller;


import com.contract.dto.OrderDTO;
import com.contract.dto.ResultDTO;
import com.contract.service.ContractService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


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
     * @return 合同ID
     */
    @ResponseBody
    @PostMapping("/getContract")
    public ResultDTO getContract(MultipartFile file, String idNum,String item,String price,String companyCode,String bankNum,
                                 String bankName,String branchBankName,MultipartFile bankImage,String startDate,String endDate,String phoneNum,String orderId) {
        return ResultDTO.okOf(contractService.getContract(file,idNum,item,price,companyCode,bankNum,bankName,branchBankName,bankImage,startDate,endDate,phoneNum,orderId));
    }

//    /**
//     * 上传对应合同的银行卡照片,同时生成订单
//     * @param  bankImage
//     * @return 合同存储路径
//     */
//    @ResponseBody
//    @PostMapping("/uploadContractBankImage")
//    public ResultDTO uploadContractBankImage(MultipartFile bankImage) {
//        return ResultDTO.okOf(contractService.uploadContractBankImage(bankImage));
//    }




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
     * 获得指定合同审核状态
     * @return 状态
     */
    @ResponseBody
    @PostMapping("/getOrderStatus")
    public ResultDTO getOrderStatus(String phoneNum)
    {
        return ResultDTO.okOf(contractService.getOrderStatus(phoneNum));
    }

//    /**
//     * 根据orderId获得下载地址
//     * @return 状态
//     */
//    @ResponseBody
//    @PostMapping("/getOrderUrl")
//    public ResultDTO getOrderUrl(Long orderId)
//    {
//        return ResultDTO.okOf(contractService.getOrderUrl(orderId));
//    }



    /**
     * 通过指定合同审核
     * @return 信息
     */
    @ResponseBody
    @RequestMapping("/passOrder")
    public ResultDTO passOrder(HttpServletRequest request)
    {
        return ResultDTO.okOf(contractService.changeOrderStatus(request.getParameter("id"),10));
    }


    /**
     * 不通过指定合同审核
     * @return 信息
     */
    @ResponseBody
    @RequestMapping("/notPassOrder")
    public ResultDTO notPassOrder(HttpServletRequest request)
    {
        return ResultDTO.okOf(contractService.changeOrderStatus(request.getParameter("id"),20));
    }

    /**
     * 删除指定合同记录
     * @return 信息
     */
    @ResponseBody
    @RequestMapping("/deleteOrder")
    public ResultDTO deleteOrder(HttpServletRequest request)
    {
        return ResultDTO.okOf(contractService.deleteOrder(request.getParameter("id")));
    }


    /**
     * 确保合同唯一
     * @param item
     * @param company
     * @param idNum
     * @return
     */
    @ResponseBody
    @RequestMapping("/onlyOne")
    public ResultDTO onlyOne(String item,String company,String idNum)
    {
        return ResultDTO.okOf(contractService.onlyOne(item,company,idNum));
    }

    /**
     * 获得所有合同列表
     * @param idNum
     * @return
     */
    @ResponseBody
    @RequestMapping("/getOrders")
    public ResultDTO getOrders(String idNum)
    {
        return ResultDTO.okOf(contractService.getOrders(idNum));
    }


    /**
     * 更新合同
     * @param orderDTO
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public ResultDTO update(@RequestBody OrderDTO orderDTO)
    {
        return ResultDTO.okOf(contractService.update(orderDTO));
    }


    /**
     * 给合同盖章
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/stamp")
    public ResultDTO stamp(String id)
    {
        return ResultDTO.okOf(contractService.stamp(id));
    }



}
