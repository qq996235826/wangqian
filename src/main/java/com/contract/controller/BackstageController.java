package com.contract.controller;

import com.contract.service.BackstageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
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
    @GetMapping("/database")
    public String database()
    {
        return "database";
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
     * 负责给easyUI的审核页面表格返回数据
     * @return Map
     */
    @RequestMapping("/getSuppliers")
    @ResponseBody
    public Map getSuppliers()
    {
        return backstageService.getSuppliers();
    }

    /**
     * 负责给easyUI的审核页面表格返回数据
     * @return Map
     */
    @RequestMapping("/getOrdersInfo")
    @ResponseBody
    public Map getOrdersInfo()
    {
        return backstageService.getOrdersInfo();
    }
}
