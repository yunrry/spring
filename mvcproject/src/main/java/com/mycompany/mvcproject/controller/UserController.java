package com.mycompany.mvcproject.controller;

import com.mycompany.mvcproject.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    // http://localhost:8080/user/signup
    @GetMapping("/signup")
    public String signup(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    //@RequestMapping(value = "/signup", method = RequestMethod.POST)
    @PostMapping("/signup")
    //@ResponseBody  //view 페이지가 아니라 data 그대로의 String response(응답)
    public String signup(
            //@ModelAttribute("user") User user
            @ModelAttribute User user
    ) {
        System.out.println(user);
        //return "success";
        // return "redirect:/hello"; // 가입 후에 /hello
        return "redirect:https://www.naver.com";
    }
}
