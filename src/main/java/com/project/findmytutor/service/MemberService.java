package com.project.findmytutor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.findmytutor.repository.MemberRepository;
import com.project.findmytutor.domain.Member;
import com.project.findmytutor.dto.response.MemberResponse;

@Service
@Transactional
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;
    
    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("There's no such member."));
    }

    public MemberResponse getMemberInfo(String email) {
        return memberRepository.findByEmail(email)
                .map(MemberResponse::of)
                .orElseThrow(() -> new RuntimeException("There's no that member info."));
    }
}
