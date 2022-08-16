package com.project.findmytutor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.findmytutor.model.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByKey (String key);

}
