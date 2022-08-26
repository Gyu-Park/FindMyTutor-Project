package com.project.findmytutor.dto.response;

import com.project.findmytutor.domain.Lesson;
import com.project.findmytutor.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestCardResponse {

    String senderName;
    String senderEmail;
    String senderPhone;
    String senderMessage;
    Lesson lesson;

    public static RequestCardResponse of(final Member sender, String message, Lesson lesson) {
        return new RequestCardResponse(sender.getName(), sender.getEmail(), sender.getPhone(), message, lesson);
    }
    
}
