package com.example.exchangeratesbackend.repository;

import com.example.exchangeratesbackend.entitie.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Token findByJwtAndRefresh(String jwt, String refresh);
}