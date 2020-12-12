package com.example.exchangeratesbackend.service;

import com.example.exchangeratesbackend.dto.NewRateDto;
import com.example.exchangeratesbackend.entitie.Currency;
import com.example.exchangeratesbackend.entitie.Rate;
import com.example.exchangeratesbackend.error.ResourceConflict;
import com.example.exchangeratesbackend.error.ResourceNotFound;
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

    public void addRate(NewRateDto newRateDto, Boolean force){
        String name = newRateDto.getName();
        Currency currency = currencyRepository.findByName(name);
        if(currency == null){
            throw new ResourceNotFound();
        }

        Rate existingRate = rateRepository.findByCurrencyIdAndDate(currency.getId(), newRateDto.getDate());

        if(existingRate == null){
            Rate newRate = new Rate();
            newRate.setCurrencyId(currency.getId());
            newRate.setDate(newRateDto.getDate());
            newRate.setValue(newRateDto.getValue());
            rateRepository.save(newRate);
        }
        else if(!force && existingRate != null){
            throw new ResourceConflict();
        }
        else if(force && existingRate != null){
            rateRepository.delete(existingRate);
            Rate newRate = new Rate();
            newRate.setCurrencyId(currency.getId());
            newRate.setDate(newRateDto.getDate());
            newRate.setValue(newRateDto.getValue());
            rateRepository.save(newRate);
        }

    }

    public void deleteRate(long rateId){
        Optional<Rate> deleteRate = rateRepository.findById(rateId);
        if(deleteRate.isPresent()){
            rateRepository.delete(deleteRate.get());
        }else{
            throw new NoSuchElementException();
        }
    }

}
