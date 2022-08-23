package com.project.findmytutor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.findmytutor.dto.response.MemberResponse;
import com.project.findmytutor.service.MemberService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/api/member")
@AllArgsConstructor
public class MemberController {

    private final MemberService memberService;
    
    @GetMapping("/{email}")
    public ResponseEntity<MemberResponse> getMemberInfo (@PathVariable String email) {
        return ResponseEntity.ok(memberService.getMemberInfo(email));
    }
    
}
