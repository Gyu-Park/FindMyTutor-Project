package com.project.findmytutor.dto.response;

import lombok.Getter;

import com.project.findmytutor.domain.Member;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberResponse {

    private Long id;
    private String email;
    private String name;
    private String role;

    public static MemberResponse of(final Member member) {
        return new MemberResponse(member.getId(), member.getEmail(), member.getName(), member.getRole());
    }

}
