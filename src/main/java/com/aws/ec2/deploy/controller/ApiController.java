package com.aws.ec2.deploy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @GetMapping("hello")
    public String hello() {
        return "Hello, I am being printed from ec2 ...";
    }


    @GetMapping("hello2")
    public String hello2() {
        return "Hi Mahmudur ...";
    }
}
