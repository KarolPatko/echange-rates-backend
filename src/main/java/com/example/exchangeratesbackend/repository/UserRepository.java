package com.example.exchangeratesbackend.repository;

import com.example.exchangeratesbackend.entitie.Rate;
import com.example.exchangeratesbackend.entitie.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User getByLogin(String login);
    User getById(Long Id);

    Optional<User> findUserByLogin(String login);
}
