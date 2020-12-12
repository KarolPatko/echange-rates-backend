package com.example.exchangeratesbackend.controller;

import com.example.exchangeratesbackend.dto.NewCurrencyDto;
import com.example.exchangeratesbackend.entitie.projection.CurrencyRateProjection;
import com.example.exchangeratesbackend.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/currency")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @GetMapping
    public List<CurrencyRateProjection> getAllCurrencies(){
        return currencyService.getAllCurrencies();
    }

    @PostMapping
    public void addCurrency(@RequestBody NewCurrencyDto newCurrencyDto){
        currencyService.addCurrency(newCurrencyDto);
    }

}
