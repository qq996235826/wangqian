package com.contract.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author deng
 * @version 1.0
 * @description 拦截器
 * @date 2020/12/26 15:16
 */
//@Configuration
public class SpringInterceptor implements HandlerInterceptor
{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
//        String token=request.getParameter("token");
//        if(token!=null&&redisUtil.hasKey(token))
//        {
//            return true;
//        }
//        else
//        {
//            PrintWriter writer = null;
//            response.setCharacterEncoding("UTF-8");
//            response.setContentType("application/json; charset=utf-8");
//            try {
//                writer = response.getWriter();
//                Map<String, Object> result=new HashMap<>();
//                result.put("status",500);
//                result.put("message", "用户令牌token无效");
//                writer.print(result);
//            } catch (IOException e){
//                e.printStackTrace();
//            } finally {
//                if(writer != null){
//                    writer.close();
//                }
//            }
//            return false;
//        }

        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {

    }
}
