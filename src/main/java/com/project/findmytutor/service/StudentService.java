package com.project.findmytutor.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.findmytutor.model.Student;
import com.project.findmytutor.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }
}
