package com.example.exchangeratesbackend.service;

import com.example.exchangeratesbackend.dto.NewRateDto;
import com.example.exchangeratesbackend.entitie.Currency;
import com.example.exchangeratesbackend.entitie.Rate;
import com.example.exchangeratesbackend.repository.CurrencyRepository;
import com.example.exchangeratesbackend.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RateService {

    @Autowired
    RateRepository rateRepository;
    @Autowired
    CurrencyRepository currencyRepository;

    public void addRate(NewRateDto newRateDto){
        Rate newRate = new Rate();
        String name = newRateDto.getName();
        Currency currency = currencyRepository.findByName(name);

        newRate.setCurrencyId(currency.getId());
        newRate.setDate(newRateDto.getDate());
        newRate.setValue(newRateDto.getValue());

        rateRepository.save(newRate);
    }

    public void deleteRate(long rateId){
        Optional<Rate> deleteRate = rateRepository.findById(rateId);
        if(deleteRate.isPresent()){
            rateRepository.deleteById(rateId);
        }else{
            throw new NoSuchElementException();
        }

    }

}
