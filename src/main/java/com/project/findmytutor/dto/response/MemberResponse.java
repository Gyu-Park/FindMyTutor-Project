package com.project.findmytutor.dto.response;

import lombok.Getter;

import com.project.findmytutor.model.Member;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString
public class MemberResponse {

    private Long memberId;
    private String email;
    private String name;

    public static MemberResponse of(final Member member) {
        return new MemberResponse(member.getMemberId(), member.getEmail(), member.getName());
    }

}
