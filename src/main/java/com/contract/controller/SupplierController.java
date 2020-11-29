package com.contract.controller;

import com.contract.dto.ResultDTO;
import com.contract.dto.SupplierDTO;
import com.contract.service.SupplierService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;

/**
 * @author deng
 * @version 1.0
 * @description 负责供货人的controller
 * @date 2020/11/5 19:22
 */
@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Resource
    private SupplierService supplierService;

    /**
     * 通过身份证号注册供货人
     * @return 返回供货人的id主键
     */
    @ResponseBody
    @PostMapping("/create")
    public ResultDTO createSupplier(@RequestBody SupplierDTO supplierDTO) {
        return ResultDTO.okOf(supplierService.createSupplier(supplierDTO));
    }


    /**
     * 登录借接口
     * @return 成功与否
     */
    @ResponseBody
    @PostMapping("/logIn")
    public ResultDTO logIn(String idNum,String password) {
        return ResultDTO.okOf(supplierService.logIn(idNum,password));
    }

    /**
     * 完善供货人信息
     * @return 是否成功
     */
    @ResponseBody
    @PostMapping("/addInfo")
    public ResultDTO addSupplierInfo(@RequestBody SupplierDTO supplierDTO) {
        return ResultDTO.okOf(supplierService.addSupplierInfo(supplierDTO));
    }
    //上传图片信息
    @ResponseBody
    @PostMapping("/uploadImage")
    public ResultDTO uploadSignature(MultipartFile upload,String idNum, String role) {
        return ResultDTO.okOf(supplierService.uploadImage(upload,idNum,role));
    }

    //判断该身份证号是否注册
    @ResponseBody
    @PostMapping("/idNumRegistered")
    public ResultDTO phoneRegistered(String idNum) {
        return ResultDTO.okOf(supplierService.Registered(idNum));
    }

    //提供供货人信息:姓名,身份号,住址,身份证有效期
    @ResponseBody
    @PostMapping("/getSupplierInfo")
    public ResultDTO getSupplierInfo(String idNum) {
        return ResultDTO.okOf(supplierService.getSupplierInfo(idNum));
    }

    @ResponseBody
    @PostMapping("/changePassword")
    public ResultDTO changePassword(String idNum,String oldPassword,String newPassword)
    {
        return ResultDTO.okOf(supplierService.changePassword(idNum,oldPassword,newPassword));
    }

}
