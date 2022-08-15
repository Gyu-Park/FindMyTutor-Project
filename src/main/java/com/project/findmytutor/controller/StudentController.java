package com.project.findmytutor.controller;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.findmytutor.model.Student;
import com.project.findmytutor.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/api/student")
@AllArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    @QueryMapping
    Iterable<Student> students() {
        return studentRepository.findAll();
    }    
}
