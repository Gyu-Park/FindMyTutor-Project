package com.project.findmytutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.findmytutor.domain.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    
}
