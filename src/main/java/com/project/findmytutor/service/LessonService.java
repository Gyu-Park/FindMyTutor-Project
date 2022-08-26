package com.project.findmytutor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    public Lesson findById(Long id) {
        return lessonRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("There's no such lesson."));
    } 

    public Lesson post(LessonPostRequest lessonRequest) {
        return lessonRepository.save(lessonRequest.toLesson());
    }

    public List<Lesson> search(LessonSearchRequest lessonSearchRequest) {
        int price = Integer.parseInt(lessonSearchRequest.getPrice()) + 10;
        return lessonRepository.findByMethodAndSubjectAndPriceBetween(
                                            lessonSearchRequest.getMethod(), 
                                            lessonSearchRequest.getSubject(), 
                                            lessonSearchRequest.getPrice(),
                                            String.valueOf(price))
                                            .orElse(null);
    }

    public Page<Lesson> pagination(List<Lesson> list, String page) {
        PageRequest pageRequest = PageRequest.of(Integer.parseInt(page) - 1, 10);
    
        int total = list.size();
        int start = (int) pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()), total);
        
        List<Lesson> output = new ArrayList<>();
        if (start <= end)
            output = list.subList(start, end);

        return new PageImpl<>(output, pageRequest, total);
    }
}
