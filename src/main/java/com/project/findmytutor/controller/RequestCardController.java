package com.project.findmytutor.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.findmytutor.domain.Lesson;
import com.project.findmytutor.domain.Member;
import com.project.findmytutor.domain.RequestCard;
import com.project.findmytutor.dto.request.RequestCardRequest;
import com.project.findmytutor.dto.response.RequestCardResponse;
import com.project.findmytutor.service.LessonService;
import com.project.findmytutor.service.MemberService;
import com.project.findmytutor.service.RequestCardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/requestCard")
@RequiredArgsConstructor
public class RequestCardController {

    private final RequestCardService requestCardService;
    private final MemberService memberService;
    private final LessonService lessonService;

    @GetMapping("/getAllrequestCards")
    public ResponseEntity<List<RequestCardResponse>> getAllrequestCards(Principal principal) {
        Member receiver = memberService.findByEmail(principal.getName());
        List<RequestCard> requestCards = requestCardService.findAllByReceiver(receiver);
        List<RequestCardResponse> response = new ArrayList<>();
        for (RequestCard card : requestCards) {
            response.add(RequestCardResponse.of(memberService.findByEmail(card.getSender()), 
                card.getMessage(), 
                card.getLesson()));
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/sendRequestCard")
    public ResponseEntity<Void> sendRequestCard(@RequestBody @Valid RequestCardRequest requestCardRequest) {
        Lesson lesson = lessonService.findById(requestCardRequest.getLessonId());
        requestCardService.save(requestCardRequest.toRequestCard(lesson));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
