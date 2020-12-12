package com.example.exchangeratesbackend.controller;


import com.example.exchangeratesbackend.dto.NewActiveDto;
import com.example.exchangeratesbackend.dto.NewRoleDto;
import com.example.exchangeratesbackend.dto.NewUserDto;
import com.example.exchangeratesbackend.dto.UserDto;
import com.example.exchangeratesbackend.entitie.User;
import com.example.exchangeratesbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public User register(@RequestBody NewUserDto newUserDto){
        return userService.register(newUserDto);
    }

    @PostMapping("{userId}/role")
    public void changeRole(@PathVariable Long userId, @RequestBody NewRoleDto newRoleDto){
        userService.changeRole(userId, newRoleDto);
    }

    @PostMapping("{userId}/delete")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }

    @PostMapping("{userId}/active")
    public void changeActive(@PathVariable Long userId, @RequestBody NewActiveDto newActiveDto){
        userService.changeActive(userId, newActiveDto);
    }
}
