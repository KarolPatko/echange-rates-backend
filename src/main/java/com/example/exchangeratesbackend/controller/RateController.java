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
    public void addRate(@RequestBody NewRateDto newRateDto,
                        @RequestParam(name = "force", required = false, defaultValue = "false") Boolean force){
        rateService.addRate(newRateDto, force);
    }

    @DeleteMapping("/{rateId}")
    public void deleteRate(@PathVariable("rateId") Long rateId){
        rateService.deleteRate(rateId);
    }

}
