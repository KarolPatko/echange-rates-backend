package com.example.exchangeratesbackend;

import com.example.exchangeratesbackend.entitie.Currency;
import com.example.exchangeratesbackend.entitie.Rate;
import com.example.exchangeratesbackend.entitie.User;
import com.example.exchangeratesbackend.repository.CurrencyRepository;
import com.example.exchangeratesbackend.repository.RateRepository;
import com.example.exchangeratesbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DataLoader {
    CurrencyRepository currencyRepository;
    RateRepository rateRepository;
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public DataLoader(CurrencyRepository currencyRepository, RateRepository rateRepository,
                      UserRepository userRepository,
                      PasswordEncoder passwordEncoder){
        this.currencyRepository = currencyRepository;
        this.rateRepository = rateRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        loadRate();
        loadUser();
    }

    private void loadRate(){
        Currency currency2 = new Currency();
        currency2.setName("GBP");
        currencyRepository.save(currency2);

        Currency currency3 = new Currency();
        currency3.setName("EUR");
        currencyRepository.save(currency3);

        Currency currency4 = new Currency();
        currency4.setName("USD");
        currencyRepository.save(currency4);

        Currency currency5 = new Currency();
        currency5.setName("CHF");
        currencyRepository.save(currency5);

        Currency currency6 = new Currency();
        currency6.setName("JPY");
        currencyRepository.save(currency6);

        Currency currency7 = new Currency();
        currency7.setName("BTX");
        currencyRepository.save(currency7);

        Rate rate3 = new Rate();
        LocalDate localDate3 = LocalDate.parse("2020-12-14", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate3.setDate(localDate3);
        rate3.setCurrencyId(currency2.getId());
        rate3.setValue(new Double(2));
        rateRepository.save(rate3);

        Rate rate4 = new Rate();
        LocalDate localDate4 = LocalDate.parse("2020-12-14", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate4.setDate(localDate4);
        rate4.setCurrencyId(currency3.getId());
        rate4.setValue(new Double(1.5));
        rateRepository.save(rate4);

        Rate rate6 = new Rate();
        LocalDate localDate6 = LocalDate.parse("2020-12-15", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate6.setDate(localDate6);
        rate6.setCurrencyId(currency3.getId());
        rate6.setValue(new Double(2));
        rateRepository.save(rate6);

        Rate rate7 = new Rate();
        LocalDate localDate7 = LocalDate.parse("2020-12-16", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate7.setDate(localDate7);
        rate7.setCurrencyId(currency3.getId());
        rate7.setValue(new Double(3));
        rateRepository.save(rate7);

        Rate rate5 = new Rate();
        LocalDate localDate5 = LocalDate.parse("2020-12-14", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate5.setDate(localDate5);
        rate5.setCurrencyId(currency4.getId());
        rate5.setValue(new Double(100));
        rateRepository.save(rate5);

        Rate rate8 = new Rate();
        LocalDate localDate8 = LocalDate.parse("2020-12-14", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate8.setDate(localDate8);
        rate8.setCurrencyId(currency5.getId());
        rate8.setValue(new Double(2));
        rateRepository.save(rate8);

        Rate rate9 = new Rate();
        LocalDate localDate9 = LocalDate.parse("2020-12-14", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate9.setDate(localDate9);
        rate9.setCurrencyId(currency6.getId());
        rate9.setValue(new Double(100));
        rateRepository.save(rate9);

        Rate rate10 = new Rate();
        LocalDate localDate10 = LocalDate.parse("2020-12-14", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate10.setDate(localDate10);
        rate10.setCurrencyId(currency7.getId());
        rate10.setValue(new Double(100));
        rateRepository.save(rate10);
    }

    private void loadUser(){
        String password = passwordEncoder.encode("password");

        User user1 = new User();
        user1.setActive(true);
        user1.setLastName("name");
        user1.setName("lastName");
        user1.setLogin("user");
        user1.setRole("USER");
        user1.setPassword(password);
        userRepository.save(user1);

        User user2 = new User();
        user2.setActive(true);
        user2.setLastName("name");
        user2.setName("lastName");
        user2.setLogin("admin");
        user2.setRole("ADMIN");
        user2.setPassword(password);
        userRepository.save(user2);
    }
}
