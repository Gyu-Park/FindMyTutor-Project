package com.project.findmytutor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @GetMapping("")
    public String account() {
        return "account";
    }

    @GetMapping("/tutorRequest")
    public String tutorRequest() {
        return "tutorRequest";
    }
    
}
