package com.mycompany.mvcproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    // http://localhost:8080/reuestParamTest
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
}
