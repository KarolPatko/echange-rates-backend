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
        currencyRepository.save(currency);
    }

    private void loadRate(){
        Rate rate1 = new Rate();
        LocalDate localDate1 = LocalDate.parse("2020-12-12 13:40", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        rate1.setDate(localDate1);
        rate1.setCurrencyId(new Long(1));
        rate1.setValue(new Double(1));
        rateRepository.save(rate1);

        Rate rate2 = new Rate();
        LocalDate localDate2 = LocalDate.parse("2020-12-12 14:40", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        rate2.setDate(localDate2);
        rate2.setCurrencyId(new Long(1));
        rate2.setValue(new Double(2));
        rateRepository.save(rate2);
    }
}
