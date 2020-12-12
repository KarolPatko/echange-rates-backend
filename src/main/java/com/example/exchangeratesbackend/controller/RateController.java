package com.example.exchangeratesbackend.controller;

import com.example.exchangeratesbackend.dto.NewCurrencyDto;
import com.example.exchangeratesbackend.dto.NewRateDto;
import com.example.exchangeratesbackend.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("api/rate")
public class RateController {

    @Autowired
    RateService rateService;

    @PostMapping
    public void addRate(@RequestBody NewRateDto newRateDto){
        rateService.addRate(newRateDto);
    }

    @DeleteMapping
    public void deleteRate(@PathParam("rateId") long rateId){
        rateService.deleteRate(rateId);
    }

}
