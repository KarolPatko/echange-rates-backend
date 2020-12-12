package com.example.exchangeratesbackend.controller;

import com.example.exchangeratesbackend.dto.LoggedUserDataDto;
import com.example.exchangeratesbackend.dto.LoginDataDto;
import com.example.exchangeratesbackend.dto.TokenDto;
import com.example.exchangeratesbackend.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/token")
public class TokenController {

    @Autowired
    TokenService tokenService;

    @PostMapping
    public LoggedUserDataDto login(@RequestBody LoginDataDto loginDataDto){
        return tokenService.login(loginDataDto);
    }

    @PostMapping("refresh")
    public TokenDto refresh(@RequestBody TokenDto TokenDto){
        return tokenService.refresh(TokenDto);
    }
}
