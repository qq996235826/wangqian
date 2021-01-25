package com.contract.controller;

import com.contract.dto.*;
import com.contract.service.BackstageService;
import com.contract.service.CompanyService;
import com.contract.service.ContractService;
import com.contract.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author deng
 * @version 1.0
 * @description 负责网页的controller
 * @date 2020/11/10 21:23
 */
@Controller
@RequestMapping("/web")
public class BackstageController
{

    @Resource
    private BackstageService backstageService;

    @Resource
    private ContractService contractService;

    @Resource
    private SupplierService supplierService;

    @Resource
    private CompanyService companyService;


    /**
     * 负责页面跳转
     *
     * @return String
     */
    @GetMapping("/index")
    public String index()
    {
        return "index";
    }

    /**
     * 负责页面跳转
     *
     * @return String
     */
    @GetMapping("/templateManagement")
    public String templateManagement()
    {
        return "templateManagement";
    }

    /**
     * 负责页面跳转
     *
     * @return String
     */
    @GetMapping("/review")
    public String review()
    {
        return "review";
    }

    /**
     * 负责页面跳转
     *
     * @return String
     */
    @GetMapping("/supplier")
    public String supplier()
    {
        return "supplier";
    }

    /**
     * 负责页面跳转
     *
     * @return String
     */
    @GetMapping("/contractList")
    public String contractList()
    {
        return "contractList";
    }

    /**
     * 负责给easyUI的审核页面表格返回数据
     *
     * @return Map
     */
    @RequestMapping("/getOrders")
    @ResponseBody
    public Map getOrders(HttpServletRequest request)
    {
        return backstageService.getOrders(request);
    }


    /**
     * 负责给easyUI的供货人页面表格返回数据
     *
     * @return Map
     */
    @RequestMapping("/getSuppliers")
    @ResponseBody
    public Map getSuppliers(HttpServletRequest request)
    {
        return backstageService.getSuppliers(request);
    }

    /**
     * 负责给easyUI的合同清单页面表格返回数据
     *
     * @return Map
     */
    @RequestMapping("/getOrdersInfo")
    @ResponseBody
    public Map getOrdersInfo(HttpServletRequest request)
    {
        return backstageService.getOrdersInfo(request);
    }

    /**
     * 负责给easyUI的模板管理页面表格返回数据
     *
     * @return Map
     */
    @RequestMapping("/getTemplates")
    @ResponseBody
    public Map getTemplates(HttpServletRequest request)
    {
        return backstageService.getTemplates(request);
    }


    @RequestMapping("/getCountOfOrders")
    @ResponseBody
    public ResultDTO getCountOfOrders()
    {
        return ResultDTO.okOf(backstageService.getCountOfOrders());
    }

    /**
     * 上传新的合同接口
     *
     * @param upload
     * @return 合同模板存储路径
     */
    @ResponseBody
    @PostMapping("/uploadContractTemplate")
    public ResultDTO uploadContract(MultipartFile upload)
    {
        return ResultDTO.okOf(contractService.uploadContractTemplate(upload));
    }

    /**
     * 上传盖章文件
     *
     * @param upload
     * @param id
     * @return
     */
    @ResponseBody
    @PostMapping("/uploadContractFile")
    public ResultDTO uploadContractFile(MultipartFile upload, String id)
    {
        return ResultDTO.okOf(contractService.uploadContractFile(upload, id));
    }

    /**
     * 通过指定合同审核
     *
     * @return 信息
     */
    //-1--未签名 0--已提交(签名,没审核),10--待盖章(有了签名,有审核,没盖章),90--已生效(上传了盖章文件),20--已失效
    @ResponseBody
    @RequestMapping("/passOrder")
    public ResultDTO passOrder(HttpServletRequest request)
    {
        return ResultDTO.okOf(contractService.changeOrderStatus(request.getParameter("id"), 10));
    }

    /**
     * 不通过指定合同审核
     *
     * @return 信息
     */
    @ResponseBody
    @RequestMapping("/notPassOrder")
    public ResultDTO notPassOrder(HttpServletRequest request)
    {
        return ResultDTO.okOf(contractService.changeOrderStatus(request.getParameter("id"), 20));
    }

    /**
     * 删除指定合同记录
     *
     * @return 信息
     */
    @ResponseBody
    @RequestMapping("/deleteOrder")
    public ResultDTO deleteOrder(HttpServletRequest request)
    {
        return ResultDTO.okOf(contractService.changeOrderStatus(request.getParameter("id"), 20));
    }

    /**
     * 更新合同
     *
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
     * 停用供货人
     *
     * @return 信息
     */
    @ResponseBody
    @RequestMapping("/deactivate")
    public ResultDTO deactivate(HttpServletRequest request)
    {
        return ResultDTO.okOf(supplierService.deactivate(request.getParameter("id")));
    }

    /**
     * 停用供货人
     *
     * @return 信息
     */
    @ResponseBody
    @RequestMapping("/enable")
    public ResultDTO enable(HttpServletRequest request)
    {
        return ResultDTO.okOf(supplierService.enable(request.getParameter("id")));
    }

    @ResponseBody
    @RequestMapping("/addOrderByWeb")
    public ResultDTO addOrderByWeb(@RequestBody AddByWebDTO addByWebDTO)
    {
        return ResultDTO.okOf(contractService.addOrderByWeb(addByWebDTO));
    }

    @ResponseBody
    @RequestMapping("/getCompany")
    public List<Map<String, Object>> getCompany()
    {
        return companyService.getCompanies();
    }

    @ResponseBody
    @RequestMapping("/getContractStatus")
    public List<Map<String, Object>> getContractStatus()
    {
        return backstageService.getContractStatus();
    }

    @ResponseBody
    @RequestMapping("/supplierOnlyOne")
    public ResultDTO supplierOnlyOne(String idNum)
    {
        return ResultDTO.okOf(supplierService.haveIdNum(idNum));
    }

    @ResponseBody
    @RequestMapping("/addSupplier")
    public ResultDTO addSupplier(@RequestBody SupplierDTO supplierDTO)
    {
        Long id = 0L;
        try
        {
            supplierService.createSupplier(supplierDTO);
            id = supplierService.addSupplierInfo(supplierDTO);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResultDTO.okOf(false);
        }
        return ResultDTO.okOf(id);
    }

    @ResponseBody
    @RequestMapping("/getInfo")
    public ResultDTO getName(HttpServletRequest request)
    {
        return ResultDTO.okOf(supplierService.getSupplierInfo(request.getParameter("idNum")));
    }

    @ResponseBody
    @RequestMapping("/searchOrder")
    public ResultDTO searchOrder(@RequestBody SearchDTO searchDTO)
    {
        return ResultDTO.okOf(contractService.searchOrder(searchDTO));
    }


}
