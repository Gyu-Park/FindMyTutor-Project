package com.project.findmytutor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    
    public List<Member> findByRole(String role) {

        // code needed here

        return memberRepository.findAll();
    }

    public MemberResponse getMemberInfo(String email) {
        return memberRepository.findByEmail(email)
                .map(MemberResponse::of)
                .orElseThrow(() -> new RuntimeException("There's no that member info."));
    }
}
