package com.codermy.myspringsecurityplus.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.codermy.myspringsecurityplus.controller"))
                .paths(PathSelectors.any())
                .build();

    }
    /**
     * 该套 API 说明，包含作者、简介、版本、等信息
     * @return
     */
    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                .title("my-springsecurity-plus-API文档")
                .description("本文档描述了my-springsecurity-plus接口定义")
                .version("1.0")
                .build();
    }

}
