package com.mycompany.mvcproject.controller;

import com.mycompany.mvcproject.service.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final LoggedUserManagementService loggedUserManagementService;

    public MainController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    public String main(
            @RequestParam(required = false) String logout,
            Model model

    ) {
        if(logout != null) {
            loggedUserManagementService.setUserName(null);
            return "redirect:/user/login";
        }

        String userName = loggedUserManagementService.getUserName();

        if(userName == null) {
            return "redirect:/user/login";
        }

        model.addAttribute("userName", userName);
        return "main";
    }
}
