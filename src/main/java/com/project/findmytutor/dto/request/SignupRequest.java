package com.project.findmytutor.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.findmytutor.model.Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignupRequest {

    private String firstName;

    private String lastName;

    @Email(message = "Not a valid email")
    private String email;

    private String password;

    public Member toMember(PasswordEncoder passwordEncoder) {
        Member member = new Member();
        member.setEmail(email);
        member.setName(firstName + " " + lastName);
        member.setPassword(passwordEncoder.encode(password));
        return member;
    }
    
}
