package com.contract.advice;


import com.contract.dto.ResultDTO;
import com.contract.exception.CustomizeErrorCode;
import com.contract.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

//页面出错误处理类
@ControllerAdvice   //错误处理类注解,如果后面不加括号就会扫面所有地方的错误
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)  //括号里写你要拦截的错误的class字节码
    @ResponseBody
    Object handler(HttpServletRequest request, Throwable e, Model model) {//Throwable 是所有错误的父类,它负责接收抛出的错误

        //contentType是前端返回的数据类型,这里我们根据ContentType来进行分类错误处理
        String contentType = request.getContentType();

        //如果前端返回的contentType是json格式,也就是是内容方面的
        //question下错误显示的信息
        //其他错误显示的信息
        if (e instanceof CustomizeException)
        {
            //返回错误信息
            e.printStackTrace();
            return ResultDTO.errorOf((CustomizeException) e);
        } else {
            //其他错误显示的信息
            e.printStackTrace();
            return ResultDTO.errorOf(CustomizeErrorCode.SYSTEM_ERROR);
        }


    }
}
