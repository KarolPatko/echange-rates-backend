package com.example.exchangeratesbackend.controller;


import com.example.exchangeratesbackend.dto.NewUserDto;
import com.example.exchangeratesbackend.entitie.User;
import com.example.exchangeratesbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public User register(@RequestBody NewUserDto newUserDto){
        return userService.register(newUserDto);
    }
}
