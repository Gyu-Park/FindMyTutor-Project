package com.project.findmytutor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lesson {
    
    @Id
    @GeneratedValue
    private Long lessonId;

    @Column
    private String method;

    @Column
    private String subject;

    @Column
    private String price;

    @Column
    private String rating;
}
