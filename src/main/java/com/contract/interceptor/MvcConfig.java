package com.contract.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author deng
 * @version 1.0
 * @description 拦截器注册器
 * @date 2020/12/26 15:22
 */
//@Configuration
public class MvcConfig implements WebMvcConfigurer
{

    @Resource
    SpringInterceptor springInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(springInterceptor).excludePathPatterns("/web/**").excludePathPatterns("/download/**").excludePathPatterns("/supplier/create").excludePathPatterns("/supplier/logIn");
    }
}
