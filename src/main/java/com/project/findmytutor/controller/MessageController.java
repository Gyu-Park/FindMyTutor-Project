package com.project.findmytutor.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.findmytutor.domain.Member;
import com.project.findmytutor.domain.Message;
import com.project.findmytutor.service.MemberService;
import com.project.findmytutor.service.MessageService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;
    private final MemberService memberService;

    @GetMapping("/getAllMessages")
    public ResponseEntity<List<Message>> getAllMessages(Principal principal) {
        Member member = memberService.findByEmail(principal.getName());
        List<Message> messages = new ArrayList<>();
        if (member.getRole().equals("tutor")) {
            messages = messageService.findAllByReceiver(member.getEmail());
        } else {
            messages = messageService.findAllBySender(member.getEmail());
        }
        return ResponseEntity.ok(messages);
    }
    
}
