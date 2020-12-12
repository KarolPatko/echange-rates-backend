package com.example.exchangeratesbackend.controller;

import com.example.exchangeratesbackend.dto.CurrencyValueDto;
import com.example.exchangeratesbackend.dto.NewCurrencyDto;
import com.example.exchangeratesbackend.entitie.projection.CurrencyRateProjection;
import com.example.exchangeratesbackend.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/currency")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @GetMapping
    public List<CurrencyRateProjection> getAllCurrencies(){
        return currencyService.getAllCurrencies();
    }

    @GetMapping("/{currencyId}")
    public CurrencyValueDto getAllCurrencies(@PathVariable("currencyId") Long currencyId){
        return currencyService.getCurrency(currencyId);
    }

    @PostMapping
    public void addCurrency(@RequestBody NewCurrencyDto newCurrencyDto){
        currencyService.addCurrency(newCurrencyDto);
    }

}
