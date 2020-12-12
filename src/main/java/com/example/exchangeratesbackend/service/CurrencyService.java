package com.example.exchangeratesbackend.service;

import com.example.exchangeratesbackend.dto.CurrencyValueDto;
import com.example.exchangeratesbackend.dto.NewCurrencyDto;
import com.example.exchangeratesbackend.entitie.Currency;
import com.example.exchangeratesbackend.entitie.projection.CurrencyRateProjection;
import com.example.exchangeratesbackend.entitie.projection.CurrencyValuesProjection;
import com.example.exchangeratesbackend.error.ResourceConflict;
import com.example.exchangeratesbackend.repository.CurrencyRepository;
import com.example.exchangeratesbackend.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    RateRepository rateRepository;

    public List<CurrencyRateProjection> getAllCurrencies(){
        return currencyRepository.getAllProjectedBy();
    }

    public CurrencyValueDto getCurrency(Long currencyId){
        CurrencyValueDto result;
        String name;
        ArrayList<CurrencyValuesProjection> rates;
        Optional<Currency> cr = currencyRepository.findById(currencyId);
        if(cr.isPresent()){
            name=cr.get().getName();
            rates=rateRepository.findAllCurrencyValuesProjectedByCurrencyId(currencyId);
            result= new CurrencyValueDto(name, rates);
            return result;
        }else{
            throw new NoSuchElementException();
        }
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
