package com.project.findmytutor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.findmytutor.domain.RequestCard;

@Repository
public interface RequestCardRepository extends JpaRepository<RequestCard, Long> {
    List<RequestCard> findAllBySender(String sender);
    List<RequestCard> findAllByReceiver(String receiver);
}
