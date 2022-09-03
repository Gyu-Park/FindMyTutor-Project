package com.project.findmytutor.controller;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.findmytutor.domain.Lesson;
import com.project.findmytutor.dto.request.LessonSearchRequest;
import com.project.findmytutor.service.LessonService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ResultController {

    private final LessonService lessonService;
    
    @GetMapping("/result")
    public String result(@RequestParam String page, LessonSearchRequest lessonSearchRequest, Model model) {
        Page<Lesson> lessons = lessonService.pagination(lessonService.search(lessonSearchRequest), page);
        model.addAttribute("method", lessonSearchRequest.getMethod());
        model.addAttribute("subject", lessonSearchRequest.getSubject());
        model.addAttribute("price", lessonSearchRequest.getPrice());
        model.addAttribute("totalPage", lessons.getTotalPages());
        model.addAttribute("page", page);
        model.addAttribute("lessons", lessons.stream().collect(Collectors.toList()));

        return "result";
    }
    
}
