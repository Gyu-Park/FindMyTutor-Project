package com.project.findmytutor.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.findmytutor.domain.Member;
import com.project.findmytutor.dto.request.LessonRequest;
import com.project.findmytutor.repository.MemberRepository;
import com.project.findmytutor.service.LessonService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/lesson")
public class LessonController {

    private final MemberRepository memberRepository;
    private final LessonService LessonService;

    @PostMapping("/post")
    public ResponseEntity<Void> post(HttpServletRequest request, @RequestBody @Valid final LessonRequest lessonRequest) {
        Optional<Member> member = memberRepository.findByEmail(request.getUserPrincipal().getName());
        lessonRequest.setMember(member.orElseThrow(() -> new UsernameNotFoundException("There's no such member")));
        LessonService.post(lessonRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
}
