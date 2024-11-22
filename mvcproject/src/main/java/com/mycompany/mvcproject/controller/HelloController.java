package com.mycompany.mvcproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class HelloController {

    // http://localhost:8080/hello
    @RequestMapping("/hello")
    public String home(){
        return "hello";
    }

    // http://localhost:8080/requestMappingGetTest
    @RequestMapping(value = "/requestMappingGetTest", method = RequestMethod.GET)
    public String requestMappingGetTest(Model model){
        model.addAttribute("textFromController", "친구들~ 안녕!!!");
        return "requestHello";
    }

    //[오류] http://localhost:8080/reuestParamTest
    //http://localhost:8080/reuestParamTest?b=anyString
    //http://localhost:8080/reuestParamTest?a=1&b=anyString&c=false
    @RequestMapping("/reuestParamTest")
    public String requestParamTest(
            @RequestParam(name="a", required = false, defaultValue = "0") int a,
            @RequestParam("b") String b,
            @RequestParam(name="c", defaultValue = "true") boolean c
    ){
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        return "hello";
    }

    // 불특정 다수의 파라미터를 받을 때, Map 사용
    // http://localhost:8080/requestParamMapTest
    // http://localhost:8080/requestParamMapTest?param1=value&param2=value2&aaa=7777
    @GetMapping("/requestParamMapTest")
    public String requestParamMapTest(
            @RequestParam Map<String,String> map
    ){
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        return "hello";
    }

    // [오류] http://localhost:8080/pathVariableTest
    // [오류] http://localhost:8080/pathVariableTest/spring/test/complete
    // http://localhost:8080/pathVariableTest/spring/test/2024
    @GetMapping("/pathVariableTest/{a1}/{b}/{c}")
    public String pathVariableTest(
            @PathVariable(value="a1") String a,
            @PathVariable String b,
            @PathVariable int c
    ){
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        return "hello";
    }
}
