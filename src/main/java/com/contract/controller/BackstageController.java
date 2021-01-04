package com.contract.controller;

import com.contract.dto.OrderDTO;
import com.contract.dto.ResultDTO;
import com.contract.service.BackstageService;
import com.contract.service.ContractService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author deng
 * @version 1.0
 * @description 负责网页的controller
 * @date 2020/11/10 21:23
 */
@Controller
@RequestMapping("/web")
public class BackstageController {

    @Resource
    private BackstageService backstageService;

    @Resource
    private ContractService contractService;

    /**
     * 负责页面跳转
     * @return String
     */
    @GetMapping("/index")
    public String index()
    {
        return "index";
    }

    /**
     * 负责页面跳转
     * @return String
     */
    @GetMapping("/templateManagement")
    public String templateManagement()
    {
        return "templateManagement";
    }

    /**
     * 负责页面跳转
     * @return String
     */
    @GetMapping("/review")
    public String review()
    {
        return "review";
    }

    /**
     * 负责页面跳转
     * @return String
     */
    @GetMapping("/supplier")
    public String supplier()
    {
        return "supplier";
    }

    /**
     * 负责页面跳转
     * @return String
     */
    @GetMapping("/contractList")
    public String contractList()
    {
        return "contractList";
    }

    /**
     * 负责给easyUI的审核页面表格返回数据
     * @return Map
     */
    @RequestMapping("/getOrders")
    @ResponseBody
    public Map getOrders()
    {
        return backstageService.getOrders();
    }


    /**
     * 负责给easyUI的供货人页面表格返回数据
     * @return Map
     */
    @RequestMapping("/getSuppliers")
    @ResponseBody
    public Map getSuppliers()
    {
        return backstageService.getSuppliers();
    }

    /**
     * 负责给easyUI的合同清单页面表格返回数据
     * @return Map
     */
    @RequestMapping("/getOrdersInfo")
    @ResponseBody
    public Map getOrdersInfo()
    {
        return backstageService.getOrdersInfo();
    }

    /**
     * 负责给easyUI的模板管理页面表格返回数据
     * @return Map
     */
    @RequestMapping("/getTemplates")
    @ResponseBody
    public Map getTemplates()
    {
        return backstageService.getTemplates();
    }


    @RequestMapping("/getCountOfOrders")
    @ResponseBody
    public ResultDTO getCountOfOrders()
    {
        return ResultDTO.okOf(backstageService.getCountOfOrders());
    }

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
     * 上传盖章文件
     * @param upload
     * @param id
     * @return
     */
    @ResponseBody
    @PostMapping("/uploadContractFile")
    public ResultDTO uploadContractFile(MultipartFile upload,String id) {
        return ResultDTO.okOf(contractService.uploadContractFile(upload,id));
    }

    /**
     * 通过指定合同审核
     * @return 信息
     */
    //-1--未签名 0--已提交(签名,没审核),10--待盖章(有了签名,有审核,没盖章),90--已生效(上传了盖章文件),20--已失效
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
        return ResultDTO.okOf(contractService.changeOrderStatus(request.getParameter("id"),20));
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


}
