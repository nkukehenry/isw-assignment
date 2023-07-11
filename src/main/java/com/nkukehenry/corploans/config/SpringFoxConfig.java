package com.nkukehenry.corploans.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class SpringFoxConfig  {

    /*
    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nkukehenry.corploans.api"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {

        return new ApiInfo(
                "Corp Loans REST API",
                "This API grants access to a corporate loan request and approval system with vendor setup capabilities.",
                "Verson 1.0",
                "Terms of service",
                new Contact(
                        "Henry Nkuke",
                        "www.henrynkuke.com",
                        "henricsanyu@gmail.com"),
                "License of API",
                "API license URL",
                Collections.emptyList()
        );
    }

     */
}