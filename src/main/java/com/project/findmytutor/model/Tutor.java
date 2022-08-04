package com.project.findmytutor.model;

import java.util.List;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tutor {
    String name;
    String phone;
    String location;
    List<String> subject;
    String priceRange;
    String picture;

    public Tutor() {

    }

    public Tutor(String name, String phone, String location, List<String> subject, String priceRange, String picture) {
        this.name = name;
        this.phone = phone;
        this.location = location;
        this.subject = subject;
        this.priceRange = priceRange;
        this.picture = picture;
    }
}
