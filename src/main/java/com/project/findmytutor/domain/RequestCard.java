package com.project.findmytutor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestCard {

    public RequestCard(String sender, String receiver, String message, Lesson lesson) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.lesson = lesson;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String sender;

    @Column
    private String receiver;

    @Column
    private String message;

    @ManyToOne
    private Lesson lesson;
}