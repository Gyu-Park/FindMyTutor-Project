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
public class Tutor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tutorId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String priceRange;

    @Column
    private String picture;

    public Tutor() {

    }

    public Tutor(Long tutorId, String email, String password, String name, 
                String phone, String location, String priceRange, String picture) {
        this.tutorId = tutorId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.location = location;
        this.priceRange = priceRange;
        this.picture = picture;
    }
    
}
