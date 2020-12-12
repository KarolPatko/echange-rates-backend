package com.example.exchangeratesbackend;

import com.example.exchangeratesbackend.entitie.Currency;
import com.example.exchangeratesbackend.entitie.Rate;
import com.example.exchangeratesbackend.repository.CurrencyRepository;
import com.example.exchangeratesbackend.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DataLoader {
    CurrencyRepository currencyRepository;
    RateRepository rateRepository;

    @Autowired
    public DataLoader(CurrencyRepository currencyRepository, RateRepository rateRepository){
        this.currencyRepository = currencyRepository;
        this.rateRepository = rateRepository;
        loadCurrency();
        loadRate();
    }

    private void loadCurrency(){
        Currency currency = new Currency();
        currency.setName("PLN");
        currency.setId(new Long(1));
        currencyRepository.save(currency);
    }

    private void loadRate(){
        Rate rate = new Rate();
        LocalDate localDate = LocalDate.parse("2020-12-12 13:40", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        rate.setDate(localDate);
        rate.setId(new Long(1));
        rate.setCurrencyId(new Long(1));
        rate.setValue(new Double(1));
        rateRepository.save(rate);

        localDate = LocalDate.parse("2020-12-12 14:40", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        rate.setDate(localDate);
        rate.setId(new Long(2));
        rate.setCurrencyId(new Long(1));
        rate.setValue(new Double(2));
        rateRepository.save(rate);
    }
}
