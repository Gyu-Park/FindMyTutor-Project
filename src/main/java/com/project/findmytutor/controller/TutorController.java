package com.project.findmytutor.controller;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.project.findmytutor.model.Tutor;
import com.project.findmytutor.repository.TutorRepository;

@Controller
public class TutorController {

    private final TutorRepository tutorRepository;

    public TutorController(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @QueryMapping
    Iterable<Tutor> tutors() {
        return tutorRepository.findAll();
    }
    
}
