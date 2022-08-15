package com.project.findmytutor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tutor {
    
    @Id
    @GeneratedValue
    private Long tutorId;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String phone;

    // @Column
    // private String location;

    // @Column
    // private String priceRange;

    // @Column
    // private String picture;

    public Tutor() {

    }

    public Tutor(Long tutorid, String email, String password, String name, String phone) {
        this.tutorId = tutorid;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    // public Tutor(String email, String password, String name, 
    //             String phone, String location, String priceRange, String picture) {
    //     this.email = email;
    //     this.password = password;
    //     this.name = name;
    //     this.phone = phone;
    //     this.location = location;
    //     this.priceRange = priceRange;
    //     this.picture = picture;
    // }
    
}
