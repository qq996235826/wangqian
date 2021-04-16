package com.contract.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
//swagger3的注解,如果是2,这是@EnableSwagger2
@EnableOpenApi
//类名随意
public class SwaggerConfig
{

    //获得是否为生产环境
    @Value("${isOnline}")
    private boolean isOnline;

    //需要配置一个Docket的bean实例,可以配置多个Docket,只要方法名不同即可
    @Bean
    public Docket createRestApi() {
        //配置文档类型,swagger3是DocumentationType.OAS_30,如果是swagger2,则是DocumentationType.SWAGGER_2
        return new Docket(DocumentationType.OAS_30)
                //传一个apiInfo类,详情看下面
                .apiInfo(apiInfo())
                //是否启动swagger,这里可以设置成生产环境不使用
                .enable(!isOnline)
                //API组名,会显示在网页的右上角的下拉框里,如果你配置了多个Docket,那就用不同的组名区分
                .groupName("网签项目")
                .select()
                //配置接口扫描方式RequestHandlerSelectors下可以选择扫描方法
                //.basePackage("包路径")    在指定包下扫描,最常用
                //.any()                       扫描全部
                //.none()                    全部不扫描
                //.withMethodAnnotation()    扫描带指定注解的方法,参数传入注解的.class
                //.withClassAnnotation()     扫描带指定注解的类下的接口,参数也是注解的.class
                .apis(RequestHandlerSelectors.basePackage("com.contract.controller"))
                //过滤路径,any()会扫描
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建 api文档的详细信息函数,这里面的内容会显示在swagger-ui网页上
     */
    private ApiInfo apiInfo() {
        // 获取工程名称,在网页中作为标题
        String projectName = System.getProperty("user.dir");
        // 作者信息,第一个写你名字,第二个是你的个人主页,第三个是邮箱,在网页中出现在标题下面
        Contact contact=new Contact("邓浩然", "https://www.baidu.com", "996235826@qq.com");
        //使用构造器来返回ApiInfo
        return new ApiInfoBuilder()
                //设置文档标题
                .title(projectName.substring(projectName.lastIndexOf("\\") + 1) + " API接口文档")
                //设置作者
                .contact(contact)
                //设置版本
                .version("1.0")
                //简介
                .description("网签后端接口文档")
                .build();
    }


}
