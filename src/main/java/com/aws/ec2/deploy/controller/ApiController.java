package com.aws.ec2.deploy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @GetMapping("hello")
    public String hello() {
        return "My first docker container ...";
    }
}
