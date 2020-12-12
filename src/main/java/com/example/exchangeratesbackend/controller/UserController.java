package com.example.exchangeratesbackend.controller;


import com.example.exchangeratesbackend.dto.NewRoleDto;
import com.example.exchangeratesbackend.dto.NewUserDto;
import com.example.exchangeratesbackend.entitie.User;
import com.example.exchangeratesbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public User register(@RequestBody NewUserDto newUserDto){
        return userService.register(newUserDto);
    }

    @PostMapping("{userId}/role")
    public void changeRole(@PathVariable Long userId, @RequestBody NewRoleDto newRoleDto){
        userService.changeRole(userId, newRoleDto);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
}
