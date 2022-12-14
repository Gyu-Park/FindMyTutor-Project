package com.project.findmytutor.dto.request;

import javax.validation.constraints.NotBlank;

import com.project.findmytutor.domain.Lesson;
import com.project.findmytutor.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LessonPostRequest {
    
    @NotBlank(message = "Please choose method")
    private String method;

    @NotBlank(message = "Please choose subject")
    private String subject;

    @NotBlank(message = "Please set price")
    private String price;

    private Member member;

    public Lesson toLesson() {
        return new Lesson(method, subject, price, member);
    }

}
