package com.project.findmytutor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
	private String password;

    @Column(nullable = false)
    private String name;

    @Column
    private String phone;

    @Column
    private String location;

    public Student() {

    }

    public Student(Long studentId, String email, String password, String name, String phone, String location) {
        this.studentId = studentId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.location = location;
    }

}
