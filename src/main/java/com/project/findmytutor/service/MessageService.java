package com.project.findmytutor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.findmytutor.domain.Message;
import com.project.findmytutor.repository.MessageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public List<Message> findAllBySender(String sender) {
        return messageRepository.findAllBySender(sender);
    }
    
    public List<Message> findAllByReceiver(String receiver) {
        return messageRepository.findAllByReceiver(receiver);
    }
}
