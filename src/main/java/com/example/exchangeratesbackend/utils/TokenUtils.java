package com.example.exchangeratesbackend.utils;

import com.auth0.jwt.JWT;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public class TokenUtils {

    public static String getLogin(String authorization){
        return JWT.require(HMAC512(JwtProperties.SECRET.getBytes()))
                .build()
                .verify(authorization)
                .getSubject();
    }
}
