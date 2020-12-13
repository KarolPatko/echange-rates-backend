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
        Currency currency1 = new Currency();
        currency1.setName("PLN");
        currencyRepository.save(currency1);

        Currency currency2 = new Currency();
        currency2.setName("GBP");
        currencyRepository.save(currency2);

        Currency currency3 = new Currency();
        currency3.setName("WUR");
        currencyRepository.save(currency3);



        Rate rate1 = new Rate();
        LocalDate localDate1 = LocalDate.parse("2020-12-12", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate1.setDate(localDate1);
        rate1.setCurrencyId(currency1.getId());
        rate1.setValue(new Double(1));
        rateRepository.save(rate1);

        Rate rate2 = new Rate();
        LocalDate localDate2 = LocalDate.parse("2020-12-13", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate2.setDate(localDate2);
        rate2.setCurrencyId(currency1.getId());
        rate2.setValue(new Double(2));
        rateRepository.save(rate2);

        Rate rate3 = new Rate();
        LocalDate localDate3 = LocalDate.parse("2020-12-14", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate3.setDate(localDate3);
        rate3.setCurrencyId(currency2.getId());
        rate3.setValue(new Double(2));
        rateRepository.save(rate3);
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
