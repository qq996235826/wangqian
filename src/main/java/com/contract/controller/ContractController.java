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


//    /**
//     * 上传新的合同接口
//     * @param upload
//     * @return 合同模板存储路径
//     */
//    @ResponseBody
//    @PostMapping("/uploadContractTemplate")
//    public ResultDTO uploadContract(MultipartFile upload) {
//        return ResultDTO.okOf(contractService.uploadContractTemplate(upload));
//    }

//    /**
//     * 上传模板合同图片给前端客户浏览
//     * @param upload
//     * @return 图片下载链接
//     */
//    @ResponseBody
//    @PostMapping("/uploadContractTemplateImage")
//    public ResultDTO uploadContractTemplateImage(MultipartFile upload) {
//        return ResultDTO.okOf(contractService.uploadContractTemplateImage(upload));
//    }

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




//    /**
//     * 获得最新模板图片
//     * @return 图片下载链接
//     */
//    @ResponseBody
//    @PostMapping("/getContractTemplateImage")
//    public ResultDTO getContractTemplateImage()
//    {
//        return ResultDTO.okOf(contractService.getContractTemplateImage());
//    }

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
     * 给合同盖章
     * @param request
     * @return
     */
    //-1--未签名 0--已提交(签名,没审核),10--审核通过(有了签名,有审核,没盖章),90--已生效(上传了盖章文件),20--已失效
    @ResponseBody
    @RequestMapping("/stamp")
    public ResultDTO stamp(HttpServletRequest request)
    {
        return ResultDTO.okOf(contractService.changeOrderStatus(request.getParameter("id"),90));
    }





    /**
     * 获得支行名字
     * @param bankNum
     * @return
     */
    @ResponseBody
    @PostMapping("/getBankName")
    public ResultDTO getBankName(String bankNum) {
        return ResultDTO.okOf(contractService.getBankName(bankNum));
    }


}
