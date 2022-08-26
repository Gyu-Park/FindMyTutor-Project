package com.project.findmytutor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.findmytutor.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllBySender(String sender);
    List<Message> findAllByReceiver(String receiver);
}
