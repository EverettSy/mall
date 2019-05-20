/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: Swagger2Config
 * Author:   YuSong
 * Date:     2019/5/20 16:56
 * Description: Swagger2API文档的配置
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <<Swagger2API文档的配置>>
 *
 * @author Raven
 * @description: Swagger2API文档的配置
 * @date 2019/5/20 16:56
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包下controller生成API文档
                .apis(RequestHandlerSelectors.basePackage("com.raven.mall.tiny.controller"))
                //为有@Api注解的Controller生成API文档
                //.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //为有@ApiOperation注解的方法生成API文档
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        Contact contact = new Contact("Raven", "https://syraven.top/", " private Contact contact;");
        return new ApiInfoBuilder()
                .title("mall平台")
                .description("mall-tiny")
                .contact(contact)
                .version("1.0")
                .build();
    }
}