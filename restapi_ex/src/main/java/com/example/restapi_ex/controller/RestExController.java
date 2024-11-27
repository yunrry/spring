package com.example.restapi_ex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestExController {

    // http://localhost:8080/test
    @GetMapping("/test")
    public String test(){
        return "{}";
    }

    // http://localhost:8080/test2
    @GetMapping("/test2")
    public String test2(){
        return "test2";
    }
}
