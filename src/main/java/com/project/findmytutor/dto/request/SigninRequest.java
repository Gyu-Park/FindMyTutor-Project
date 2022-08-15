package com.project.findmytutor.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SigninRequest {

    @NotBlank(message = "Please Fill in your email")
    @Email(message = "Not a valid email")
    private String email;
    
    @NotNull(message = "Please Fill in your password")
    private String password;
    
}
