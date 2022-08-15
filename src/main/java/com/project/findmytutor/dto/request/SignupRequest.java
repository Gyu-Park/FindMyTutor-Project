package com.project.findmytutor.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

    @NotNull(message = "Please Fill in your first name")
    private String firstName;

    @NotNull(message = "Please Fill in your last name")
    private String lastName;

    @NotBlank(message = "Please Fill in your email")
    @Email(message = "Not a valid email")
    private String email;

    @NotNull(message = "Please Fill in your password")
    private String password;
    
}