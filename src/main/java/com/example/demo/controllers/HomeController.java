package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${prop1.firstname}")
    private String firstName;
    @Value("${prop1.lastname}")
    private String lastName;

    @GetMapping("/")
    public String showPage() {
        return firstName+" "+lastName;
    }

    @GetMapping("/test2")
    public String testPage() {
        return "test-main-menu";
    }
    @GetMapping("/test1")
    public String testPage1() {
        return "test-main-menu";
    }

}
