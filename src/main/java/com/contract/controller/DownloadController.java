package com.contract.controller;

import com.contract.exception.CustomizeErrorCode;
import com.contract.exception.CustomizeException;
import com.contract.mapper.ContractTemplateMapper;
import com.contract.mapper.OrderMapper;
import com.contract.model.ContractTemplate;
import com.contract.model.Order;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @author deng
 * @version 1.0
 * @description 下载控制
 * @date 2020/11/28 23:27
 */
@Controller
public class DownloadController {

    @Value("${rootPatch}")
    String rootPatch;

    @Resource
    OrderMapper orderMapper;

    @Resource
    ContractTemplateMapper contractTemplateMapper;


    @RequestMapping("/download")
    public ResponseEntity<byte[]> downlaodFile(String orderId, String model) {
        Order order=orderMapper.selectByPrimaryKey(Long.valueOf(orderId));
        if(order.getPdfPath()==null)
        {
            throw new CustomizeException(CustomizeErrorCode.NOT_PDF);
        }
        String fileName=order.getPdfPath().split("/")[order.getPdfPath().split("/").length-1];
        // 根路径加上传参数的路径构成文件路径地址
        File file = new File(order.getPdfPath());
        // 构建响应
        ResponseEntity.BodyBuilder bodyBuilder = ResponseEntity.ok();
        bodyBuilder.contentLength(file.length());
        // 二进制数据流
        bodyBuilder.contentType(MediaType.APPLICATION_OCTET_STREAM);
        // 文件名编码
        try {
            String encodeFileName = URLEncoder.encode(fileName, "UTF-8");
            // IE
//            if (userAgent.indexOf("MSIE")>0){
//                bodyBuilder.header("Content-Disposition","attachment;filename="+encodeFileName);
//            }else {
//
//
//            }
            // 其他浏览器
            if (model!=null&&model.equals("0")){
                // 在浏览器中打开
                URL url = new URL("file:///" + file);
                bodyBuilder.header("Content-Type","application/pdf");
                bodyBuilder.header("Content-Disposition","inline; filename=\""+encodeFileName+"\"; filename*=UTF-8''"+encodeFileName);
            }else {
                // 直接下载
                bodyBuilder.header("Content-Disposition","attachment;filename*=UTF-8''"+encodeFileName);

            }


            // 下载成功返回二进制流
            return bodyBuilder.body(FileUtils.readFileToByteArray(file));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        // 下载失败直接返回错误的请求
        return (ResponseEntity<byte[]>) ResponseEntity.badRequest();

    }


    /**
     * 获得最新合同的模板预览
     * @param templateId
     * @return
     */
    @RequestMapping("/watchTemplate")
    public ResponseEntity<byte[]> watchTemplate(String templateId) {

        ContractTemplate contractTemplate=contractTemplateMapper.selectByPrimaryKey(Long.valueOf(templateId));
        String fileName=contractTemplate.getPdfPath().split("/")[contractTemplate.getPdfPath().split("/").length-1];
        // 根路径加上传参数的路径构成文件路径地址
        File file = new File(contractTemplate.getPdfPath());
        // 构建响应
        ResponseEntity.BodyBuilder bodyBuilder = ResponseEntity.ok();
        bodyBuilder.contentLength(file.length());
        // 二进制数据流
        bodyBuilder.contentType(MediaType.APPLICATION_OCTET_STREAM);
        // 文件名编码
        try {
            String encodeFileName = URLEncoder.encode(fileName, "UTF-8");
            // IE
//            if (userAgent.indexOf("MSIE")>0){
//                bodyBuilder.header("Content-Disposition","attachment;filename="+encodeFileName);
//            }else {
//
//
//            }
            // 其他浏览器
//            URL url = new URL("file:///" + file);
            bodyBuilder.header("Content-Type","application/pdf");
            bodyBuilder.header("Content-Disposition","inline; filename=\""+encodeFileName+"\"; filename*=UTF-8''"+encodeFileName);
            // 下载成功返回二进制流
            return bodyBuilder.body(FileUtils.readFileToByteArray(file));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        // 下载失败直接返回错误的请求
        return (ResponseEntity<byte[]>) ResponseEntity.badRequest();

    }

}
