package com.example.exchangeratesbackend.repository;

import com.example.exchangeratesbackend.entitie.Rate;
import com.example.exchangeratesbackend.entitie.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getByLogin(String login);
    User getByUserId(Long userId);
}