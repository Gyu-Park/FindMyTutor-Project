package com.project.findmytutor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lesson {

    public Lesson(String method, String subject, String price, Member member) {
        this.method = method;
        this.subject = subject;
        this.price = price;
        this.member = member;
    }
    
    @Id
    @GeneratedValue
    private Long lessonId;

    @Column
    private String method;

    @Column
    private String subject;

    @Column
    private String price;

    @Column(nullable = true)
    private String rating;

    @OneToOne
    private Member member;
}
