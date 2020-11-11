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

    @GetMapping("/index")
    public String index()
    {
        return "index";
    }

    @GetMapping("/database")
    public String database()
    {
        return "database";
    }

    @GetMapping("/review")
    public String review()
    {
        return "review";
    }

    @RequestMapping("/getOrders")
    @ResponseBody
    public Map getOrders()
    {
        return backstageService.getOrders();
    }
}
