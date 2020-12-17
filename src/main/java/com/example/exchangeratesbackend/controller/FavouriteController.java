package com.example.exchangeratesbackend.controller;

import com.example.exchangeratesbackend.dto.FavouriteDto;
import com.example.exchangeratesbackend.entitie.Favourite;
import com.example.exchangeratesbackend.entitie.projection.CurrencyRateProjection;
import com.example.exchangeratesbackend.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/favourite/currency")
public class FavouriteController {
    @Autowired
    FavouriteService favouriteService;

    @GetMapping(path = "/currencyId")
    public List<Long> getAllFavouriteCurrencies(@RequestHeader("Authorization") String authorization){
        return favouriteService.getAllFavouriteCurrencies(authorization);
    }

    @GetMapping(path = "/currencies")
    public List<CurrencyRateProjection> getAllFavouriteCurrenciesObject(@RequestHeader("Authorization") String authorization){
        return favouriteService.getAllFavouriteCurrenciesObject(authorization);
    }

    @PostMapping("/{currencyId}")
    public void addOrDeleteFavourite(@RequestHeader("Authorization") String authorization,
                                       @PathVariable("currencyId") Long currencyId,
                                       @RequestBody FavouriteDto favouriteDto){
        favouriteService.addOrDeleteFavourite(authorization, favouriteDto, currencyId);
    }

}
