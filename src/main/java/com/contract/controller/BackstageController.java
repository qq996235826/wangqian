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

    @GetMapping("/reviewol")
    public String reviewol()
    {
        return "reviewol";
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
     * @Description: 获得所有供货人身份证号
     * @Author: DengHaoRan
     * @Date: 2021/3/28 13:52
     * @params: [request]
     * @return: java.util.Map
     **/
    @RequestMapping("/getSuppliersIdNum")
    @ResponseBody
    public List<Map<String, Object>> SuppliersIdNum()
    {
        return backstageService.SuppliersIdNum();
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
     * @Description: 获得单个合同信息
     * @Author: DengHaoRan
     * @Date: 2021/3/21 14:36
     * @params: [request]
     * @return: com.contract.dto.ResultDTO
     **/
    @RequestMapping("/getOrderInfo")
    @ResponseBody
    public ResultDTO getOrderInfo(HttpServletRequest request)
    {
        return ResultDTO.okOf(backstageService.getOrderInfo(request.getParameter("id")));
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
        return ResultDTO.okOf(contractService.deleteOrder(request.getParameter("id")));
    }

    /**
     * 更新合同
     *
     * @param addByWebDTO
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public ResultDTO update(@RequestBody AddByWebDTO addByWebDTO)
    {
        return ResultDTO.okOf(contractService.update(addByWebDTO));
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
    @RequestMapping("/getContractStatusNew")
    public List<Map<String, Object>> getContractStatusNew()
    {
        return backstageService.getContractStatusNew();
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
    public ResultDTO getInfo(HttpServletRequest request)
    {
        return ResultDTO.okOf(supplierService.getSupplierInfo(request.getParameter("account")));
    }

    /**
     * @Description: 条件搜索
     * @Author: DengHaoRan
     * @Date: 2021/3/11 20:43
     * @params: [searchDTO]
     * @return: com.contract.dto.ResultDTO
     **/
    @ResponseBody
    @RequestMapping("/searchOrder")
    public ResultDTO searchOrder(@RequestBody SearchDTO searchDTO)
    {
        return ResultDTO.okOf(contractService.searchOrder(searchDTO));
    }

    @ResponseBody
    @RequestMapping("/getSupplierAccount")
    public ResultDTO getSupplierAccount(HttpServletRequest request)
    {
        return ResultDTO.okOf(supplierService.getSupplierAccount(request.getParameter("idNum")));
    }



//    /**
//     * @Description: 模糊搜索
//     * @Author: DengHaoRan
//     * @Date: 2021/3/11 20:43
//     * @params: [request]
//     * @return: com.contract.dto.ResultDTO
//     **/
//    @ResponseBody
//    @RequestMapping("/searchFuzzyOrder")
//    public ResultDTO orderFuzzySearch(HttpServletRequest request)
//    {
//        return ResultDTO.okOf(contractService.orderFuzzySearch(request.getParameter("info"),Integer.valueOf(request.getParameter("rows")),Integer.valueOf(request.getParameter("page"))));
//    }

}
