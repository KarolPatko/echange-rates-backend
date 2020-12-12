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
        loadCurrency();
        loadRate();
        loadUser();
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
