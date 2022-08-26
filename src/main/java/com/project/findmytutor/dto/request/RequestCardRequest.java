package com.project.findmytutor.dto.request;

import com.project.findmytutor.domain.Lesson;
import com.project.findmytutor.domain.RequestCard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestCardRequest {

    private String sender;
    private String message;
    private Long lessonId;

    public RequestCard toRequestCard(Lesson lesson) {
        return new RequestCard(sender, lesson.getMember().getEmail(), message, lesson);
    }
    
}
