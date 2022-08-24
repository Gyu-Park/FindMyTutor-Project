package com.project.findmytutor.service;

import org.springframework.stereotype.Service;

import com.project.findmytutor.domain.Lesson;
import com.project.findmytutor.dto.request.LessonRequest;
import com.project.findmytutor.repository.LessonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepository;

    public Lesson post(LessonRequest lessonRequest) {
        return lessonRepository.save(lessonRequest.toLesson());
    }
}
