package com.example.exchangeratesbackend.service;

import com.example.exchangeratesbackend.dto.NewCurrencyDto;
import com.example.exchangeratesbackend.entitie.Currency;
import com.example.exchangeratesbackend.entitie.projection.CurrencyRateProjection;
import com.example.exchangeratesbackend.error.ResourceConflict;
import com.example.exchangeratesbackend.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    public List<CurrencyRateProjection> getAllCurrencies(){
        return currencyRepository.getAllProjectedBy();
    }

    public void addCurrency(NewCurrencyDto newCurrencyDto){
        String name = newCurrencyDto.getName();
        Currency existingCurrency = currencyRepository.findByName(name);

        if(existingCurrency == null){
            Currency currency = new Currency();
            currency.setName(name);
            currencyRepository.save(currency);
        }
        else{
            throw new ResourceConflict();
        }
    }

}
