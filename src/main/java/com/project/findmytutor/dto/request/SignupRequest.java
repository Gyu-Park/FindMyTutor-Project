package com.project.findmytutor.dto.request;

import javax.validation.constraints.Email;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.findmytutor.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data
public class SignupRequest {

    private String firstName;

    private String lastName;

    @Email(message = "Not a valid email")
    private String email;

    private String password;

    public Member toMember(PasswordEncoder passwordEncoder) {
        Member member = new Member(email, passwordEncoder.encode(password), firstName, lastName);
        return member;
    }
    
}
