package com.project.findmytutor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    public Member(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    @Id
    @GeneratedValue
    private Long memberId;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Column(nullable = true)
    private String phone;

    @Column(nullable = true)
    private String location;
    
    @Column(nullable = true)
    private String role;
}
