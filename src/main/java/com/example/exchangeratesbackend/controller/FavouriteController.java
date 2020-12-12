package com.example.exchangeratesbackend.controller;

import com.example.exchangeratesbackend.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api/favourite/currency")
public class FavouriteController {
    @Autowired
    FavouriteService favouriteService;

    @GetMapping
    public ArrayList<Long> getAllFavouriteCurrencies(@RequestHeader("Authorization") String authorization){
        return favouriteService.getAllFavouriteCurrencies(authorization);
    }

}
