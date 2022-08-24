package com.project.findmytutor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.findmytutor.domain.Lesson;
import com.project.findmytutor.dto.request.LessonPostRequest;
import com.project.findmytutor.dto.request.LessonSearchRequest;
import com.project.findmytutor.repository.LessonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepository;

    public Lesson post(LessonPostRequest lessonRequest) {
        return lessonRepository.save(lessonRequest.toLesson());
    }

    public List<Lesson> search(LessonSearchRequest lessonSearchRequest) {
        return lessonRepository.findByMethodAndSubjectAndPrice(
                                            lessonSearchRequest.getMethod(), 
                                            lessonSearchRequest.getSubject(), 
                                            lessonSearchRequest.getPrice())
                                            .orElse(null);
    }
}
