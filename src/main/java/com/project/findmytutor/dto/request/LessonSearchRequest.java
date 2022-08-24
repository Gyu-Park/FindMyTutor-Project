package com.project.findmytutor.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LessonSearchRequest {
    @NotBlank(message = "Please choose method")
    private String method;

    @NotBlank(message = "Please choose subject")
    private String subject;

    @NotBlank(message = "Please set price")
    private String price;
}
