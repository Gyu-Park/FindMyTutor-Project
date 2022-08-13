package com.project.findmytutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.findmytutor.model.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
    
}
