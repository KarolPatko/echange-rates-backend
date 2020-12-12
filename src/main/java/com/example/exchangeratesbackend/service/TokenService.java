package com.example.exchangeratesbackend.service;

import com.auth0.jwt.JWT;
import com.example.exchangeratesbackend.dto.LoggedUserDataDto;
import com.example.exchangeratesbackend.dto.LoginDataDto;
import com.example.exchangeratesbackend.dto.TokenDto;
import com.example.exchangeratesbackend.entitie.Token;
import com.example.exchangeratesbackend.entitie.User;
import com.example.exchangeratesbackend.error.ResourceNotFound;
import com.example.exchangeratesbackend.repository.TokenRepository;
import com.example.exchangeratesbackend.repository.UserRepository;
import com.example.exchangeratesbackend.utils.JwtProperties;
import com.zaxxer.hikari.pool.HikariProxyCallableStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

import javax.websocket.server.ServerEndpoint;
import java.util.Date;

import static com.example.exchangeratesbackend.utils.JwtProperties.SECRET;

@Service
public class TokenService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    TokenRepository tokenRepository;

    public LoggedUserDataDto login(LoginDataDto loginDataDto){
        User user = userRepository.getByLogin(loginDataDto.getLogin());

        if(user != null && passwordEncoder.matches(loginDataDto.getPassword(), user.getPassword())){
            String jwt = JWT.create()
                    .withSubject(user.getLogin())
                    .withClaim("role", user.getRole())
                    .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                    .sign(HMAC512(SECRET.getBytes()));

            String refreshToken = getAlphaNumericString(128);

            Token token = new Token();
            token.setJwt(jwt);
            token.setRefresh(refreshToken);
            token.setAvailable(true);
            tokenRepository.save(token);

            return new LoggedUserDataDto(jwt, refreshToken, user.getRole());
        }
        else{
            throw new ResourceNotFound();
        }
    }

    public TokenDto refresh(TokenDto tokenDto){
        Token token = tokenRepository.findByJwtAndRefresh(tokenDto.getJwt(), tokenDto.getRefresh());

        if(token == null){
            throw new ResourceNotFound();
        }

        String jwt = token.getJwt();
        String login = JWT.require(HMAC512(SECRET.getBytes()))
                .build()
                .verify(jwt)
                .getSubject();

        User user = userRepository.getByLogin(login);

        if(user == null){
            throw new ResourceNotFound();
        }

        token.setAvailable(false);
        tokenRepository.save(token);

        String newJwt = JWT.create()
                .withSubject(user.getLogin())
                .withClaim("role", user.getRole())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .sign(HMAC512(SECRET.getBytes()));

        String newRefreshToken = getAlphaNumericString(128);

        Token newToken = new Token();
        newToken.setJwt(newJwt);
        newToken.setRefresh(newRefreshToken);
        newToken.setAvailable(true);
        tokenRepository.save(newToken);

        TokenDto newTokenDto = new TokenDto();
        newTokenDto.setJwt(newJwt);
        newTokenDto.setRefresh(newRefreshToken);

        return newTokenDto;
    }





    static String getAlphaNumericString(int n)
    {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
}
