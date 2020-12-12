package com.example.exchangeratesbackend.controller;

import com.example.exchangeratesbackend.dto.NewCurrencyDto;
import com.example.exchangeratesbackend.dto.NewRateDto;
import com.example.exchangeratesbackend.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rate")
public class RateController {

    @Autowired
    RateService rateService;

    @PostMapping
    public void addRate(@RequestBody NewRateDto newRateDto){
        rateService.addRate(newRateDto);
    }

}
