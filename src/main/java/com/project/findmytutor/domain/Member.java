package com.project.findmytutor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    public Member(String email, String password, String name, String role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
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
    
    @Column
    private String role;
}
