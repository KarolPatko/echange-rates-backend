package com.example.exchangeratesbackend.service;


import com.example.exchangeratesbackend.repository.CurrencyRepository;
import com.example.exchangeratesbackend.repository.FavouriteRepository;
import com.example.exchangeratesbackend.repository.UserRepository;
import com.example.exchangeratesbackend.utils.JwtProperties;
import com.example.exchangeratesbackend.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
public class FavouriteService {
    @Autowired
    FavouriteRepository favouriteRepository;

    @Autowired
    UserRepository userRepository;

    public ArrayList<Long> getAllFavouriteCurrencies(String authToken){
        String login = TokenUtils.getLogin(
                authToken.replace(JwtProperties.TOKEN_PREFIX, "")
        );
        Long userId;
        try {
            userId=userRepository.findUserByLogin(login).get().getId();
        }catch (Exception e){
            throw new NoSuchElementException("Nie ma takowego pośród nas");
        }


        return favouriteRepository.getCurrencyIdByUserId(userId);

    }
}
