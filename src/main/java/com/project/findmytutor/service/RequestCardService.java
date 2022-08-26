package com.project.findmytutor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.findmytutor.domain.Member;
import com.project.findmytutor.domain.RequestCard;
import com.project.findmytutor.repository.RequestCardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RequestCardService {

    private final RequestCardRepository requestCardRepository;

    public RequestCard save(RequestCard requestCard) {
        return requestCardRepository.save(requestCard);
    }
    
    public List<RequestCard> findAllByReceiver(Member receiver) {
        return requestCardRepository.findAllByReceiver(receiver.getEmail());
    }
}
