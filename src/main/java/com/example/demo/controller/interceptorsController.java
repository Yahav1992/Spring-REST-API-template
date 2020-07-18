package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class interceptorsController implements WebMvcConfigurer {
    @Value("${management.endpoints.web.cors.allowed-origins}")
    private String corsAllowedOrigins;

    @Override
    public void addCorsMappings(CorsRegistry registry){
        if(corsAllowedOrigins != null){
            registry.addMapping("*").allowedOrigins(corsAllowedOrigins.split(",")).allowedMethods("*");
        }
    }
}
