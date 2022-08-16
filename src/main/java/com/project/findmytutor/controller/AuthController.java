package com.project.findmytutor.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.findmytutor.dto.request.SigninRequest;
import com.project.findmytutor.dto.request.TokenRequest;
import com.project.findmytutor.dto.response.AuthResponse;

@Controller
public class AuthController {
    private final AuthService authService;
    
    @PostMapping("/signin")
    public ResponseEntity<TokenRequest> login(@RequestBody @Valid final SigninRequest signinRequest) {
        return ResponseEntity.ok(authService.login(signinRequest));
    }

    @PostMapping("/token")
    public ResponseEntity<AuthResponse> token() {
        return ResponseEntity.ok().build();
    }
}
