package com.project.findmytutor.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.findmytutor.domain.Lesson;
import com.project.findmytutor.dto.request.LessonSearchRequest;
import com.project.findmytutor.service.LessonService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ResultController {

    private final LessonService lessonService;
    
    @GetMapping("/result")
    public String result(LessonSearchRequest lessonSearchRequest, Model model) {
        List<Lesson> lessons = lessonService.search(lessonSearchRequest);
        if (lessons.size() > 0)
            model.addAttribute("lessons", lessons);

        return "result";
    }
    
}
