package com.example.exchangeratesbackend.service;


import com.example.exchangeratesbackend.repository.CurrencyRepository;
import com.example.exchangeratesbackend.repository.FavouriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FavouriteService {
    @Autowired
    FavouriteRepository favouriteRepository;

    public ArrayList<String> getAllFavouriteCurrencies(String authToken){
        String jwt = authToken.replace(JwtProperties.TOKEN_PREFIX, "")
    }
}
