package com.example.exchangeratesbackend.repository;

import com.example.exchangeratesbackend.dto.UserDto;
import com.example.exchangeratesbackend.entitie.Rate;
import com.example.exchangeratesbackend.entitie.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    User getByLogin(String login);
    User getById(Long Id);
}