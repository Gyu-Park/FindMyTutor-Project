package com.project.findmytutor.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.findmytutor.dto.response.MemberResponse;
import com.project.findmytutor.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final MemberService memberService;

    @GetMapping("")
    public String account(HttpServletRequest request, Model model) {
        try {
            MemberResponse memberResponse = memberService.getMemberInfo(request.getUserPrincipal().getName());
            boolean isTutor = memberResponse.getRole().equals("tutor") ? true : false;
            model.addAttribute("isTutor", isTutor);
        } catch(NullPointerException e) {
            return "redirect:/";
        }
        return "account";
    }

    @GetMapping("/tutorRequest")
    public String tutorRequest() {
        return "tutorRequest";
    }
    
}
