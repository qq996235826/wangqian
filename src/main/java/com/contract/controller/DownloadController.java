package com.contract.controller;


import com.contract.mapper.OrderMapper;
import com.contract.model.Order;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("/download")
    public ResponseEntity<byte[]> downlaodFile(String orderId,String model) {
        Order order=orderMapper.selectByPrimaryKey(Long.valueOf(orderId));
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
                bodyBuilder.header("Content-Type",url.openConnection().getContentType());
                bodyBuilder.header("Content-Disposition","inline;filename*=UTF-8''"+encodeFileName);
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
}
