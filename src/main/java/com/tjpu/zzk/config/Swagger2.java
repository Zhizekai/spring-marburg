package com.tjpu.zzk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.nio.file.Path;


/**
 * 访问ip:当前tomcat端口号
 */
@Configuration
@EnableSwagger2
public class Swagger2 {



    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tjpu.zzk"))
                .paths(PathSelectors.regex("/rest/.*"))
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
        .title("zzk的测试利用swagger构建api文档")
        .description("我自己的restful风格")
        .termsOfServiceUrl("http://localhost:8080")
        .version("1.8")
        .build();
    }
}
