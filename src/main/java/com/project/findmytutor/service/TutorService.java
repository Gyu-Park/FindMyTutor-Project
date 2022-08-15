package com.project.findmytutor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.findmytutor.repository.TutorRepository;
import com.project.findmytutor.model.Tutor;

@Service
@Transactional
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;
    
    public List<Tutor> findByKeywords(String method, String subjects, String priceRange) {

        // code needed here

        return tutorRepository.findAll();
    }
}
