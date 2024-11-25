package com.mycompany.mvcproject.controller;

import com.mycompany.mvcproject.domain.User;
import com.mycompany.mvcproject.service.LoggedUserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private LoggedUserManagementService loggedUserManagementService;

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

    // http://localhost:8080/user/login
    @GetMapping("/login")
    public String login(Model model) {
        User user = new User(); // login.jsp의 user 객체와 연결하기 위해, 비어있는 User 객체 만들어서 model에 추가
        model.addAttribute("user", user);
        return "login";
    }

//    @PostMapping("/login")
//    public String login(@ModelAttribute User user, Model model) {
//        System.out.println("user email = " + user.getEmail());
//        System.out.println("user password = " + user.getPassword());
//
//        if(User.DEFAULT_EMAIL.equals(user.getEmail()) && User.DEFAULT_PASSWORD.equals(user.getPassword())) {
//            model.addAttribute("message", "You are now logged in.");
//            return "loginSuccess";
//        }else{
//            return "redirect:/user/login";
//        }
//    }

/*    @PostMapping("/login")
    public String login(
            @RequestParam String email, @RequestParam String password, // HTTP 요청 매개변수에서 자격 증명을 가져 옴.
            Model model
    ){
        System.out.println("user email = " + email);
        System.out.println("user password = " + password);

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        boolean result = user.login();

        if(result) {
            model.addAttribute("message", "로그인 성공!!!");
        }else{
            model.addAttribute("message", "로그인 실패 ㅠㅠ");
        }
        return "login";
    }*/

    @PostMapping("/login")
    public String login(
            @RequestParam String email, @RequestParam String password, // HTTP 요청 매개변수에서 자격 증명을 가져 옴.
            Model model
    ){

        // 정적 로그인 정보
        final String DEFAULT_EMAIL = "test@test.com";
        final String DEFAULT_PASSWORD = "pw1234";
        final String DEFAULT_NAME = "테스트";

        System.out.println("user email = " + email);
        System.out.println("user password = " + password);

        if(DEFAULT_EMAIL.equals(email) && DEFAULT_PASSWORD.equals(password)) {
            loggedUserManagementService.setUserName(DEFAULT_NAME);
            model.addAttribute("userName", DEFAULT_NAME);
            return "main";
        }

        model.addAttribute("message", "로그인 실패");
        return "login";
    }
}
