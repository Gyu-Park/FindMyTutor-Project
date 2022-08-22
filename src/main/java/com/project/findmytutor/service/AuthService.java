package com.project.findmytutor.service;

import javax.transaction.Transactional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.findmytutor.dto.request.SigninRequest;
import com.project.findmytutor.dto.request.SignupRequest;
import com.project.findmytutor.dto.response.MemberResponse;
import com.project.findmytutor.model.Member;
import com.project.findmytutor.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public MemberResponse signup(SignupRequest signupRequest) {
        if (memberRepository.existsByEmail(signupRequest.getEmail())) {
            throw new RuntimeException("Please use another email.");
        }

        Member member = signupRequest.toMember(passwordEncoder);
        return MemberResponse.of(memberRepository.save(member));
    }

    @Transactional
    public SigninRequest signin(SigninRequest signinRequest) {
        // 1. Generate Authentication Token based on signin ID and PW
        UsernamePasswordAuthenticationToken authenticationToken = signinRequest.toAuthentication();

        // 2. Password check
        //    when authenticate method is called, loadUserByUsername in CustomUserDetailsService is called
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        
        if (!authentication.isAuthenticated()) {
            return null;
        }

        return signinRequest;
    }
    
}
