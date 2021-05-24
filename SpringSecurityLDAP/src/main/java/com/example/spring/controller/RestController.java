package com.example.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/")
    public String displayHomePage() {
        return "HomePage";
    }
}
