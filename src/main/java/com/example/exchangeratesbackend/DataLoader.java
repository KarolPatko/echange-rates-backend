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
        currency1.setName("BTC");
        currencyRepository.save(currency1);

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

        Rate rate11 = new Rate();
        LocalDate localDate11 = LocalDate.parse("2020-12-14", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate11.setDate(localDate11);
        rate11.setCurrencyId(currency1.getId());
        rate11.setValue(new Double(11));
        rateRepository.save(rate11);

        Rate rate12 = new Rate();
        LocalDate localDate12 = LocalDate.parse("2020-12-15", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate12.setDate(localDate12);
        rate12.setCurrencyId(currency1.getId());
        rate12.setValue(new Double(10));
        rateRepository.save(rate12);

        Rate rate13 = new Rate();
        LocalDate localDate13 = LocalDate.parse("2020-12-16", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate13.setDate(localDate13);
        rate13.setCurrencyId(currency1.getId());
        rate13.setValue(new Double(9));
        rateRepository.save(rate13);

        Rate rate21 = new Rate();
        LocalDate localDate21 = LocalDate.parse("2020-12-14", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate21.setDate(localDate21);
        rate21.setCurrencyId(currency2.getId());
        rate21.setValue(new Double(2));
        rateRepository.save(rate21);

        Rate rate22 = new Rate();
        LocalDate localDate22 = LocalDate.parse("2020-12-15", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate22.setDate(localDate22);
        rate22.setCurrencyId(currency2.getId());
        rate22.setValue(new Double(2));
        rateRepository.save(rate22);

        Rate rate23 = new Rate();
        LocalDate localDate23 = LocalDate.parse("2020-12-16", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate23.setDate(localDate23);
        rate23.setCurrencyId(currency2.getId());
        rate23.setValue(new Double(18));
        rateRepository.save(rate23);

        Rate rate31 = new Rate();
        LocalDate localDate31 = LocalDate.parse("2020-12-14", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate31.setDate(localDate31);
        rate31.setCurrencyId(currency3.getId());
        rate31.setValue(new Double(1));
        rateRepository.save(rate31);

        Rate rate32 = new Rate();
        LocalDate localDate32 = LocalDate.parse("2020-12-15", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate32.setDate(localDate32);
        rate32.setCurrencyId(currency3.getId());
        rate32.setValue(new Double(2));
        rateRepository.save(rate32);

        Rate rate33 = new Rate();
        LocalDate localDate33 = LocalDate.parse("2020-12-16", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate33.setDate(localDate33);
        rate33.setCurrencyId(currency3.getId());
        rate33.setValue(new Double(4));
        rateRepository.save(rate33);

        Rate rate41 = new Rate();
        LocalDate localDate41 = LocalDate.parse("2020-12-14", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate41.setDate(localDate41);
        rate41.setCurrencyId(currency4.getId());
        rate41.setValue(new Double(15));
        rateRepository.save(rate41);

        Rate rate42 = new Rate();
        LocalDate localDate42 = LocalDate.parse("2020-12-15", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate42.setDate(localDate42);
        rate42.setCurrencyId(currency4.getId());
        rate42.setValue(new Double(1));
        rateRepository.save(rate41);

        Rate rate43 = new Rate();
        LocalDate localDate43 = LocalDate.parse("2020-12-16", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate43.setDate(localDate43);
        rate43.setCurrencyId(currency4.getId());
        rate43.setValue(new Double(5));
        rateRepository.save(rate43);

        Rate rate51 = new Rate();
        LocalDate localDate51 = LocalDate.parse("2020-12-14", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate51.setDate(localDate51);
        rate51.setCurrencyId(currency5.getId());
        rate51.setValue(new Double(10));
        rateRepository.save(rate51);

        Rate rate52 = new Rate();
        LocalDate localDate52 = LocalDate.parse("2020-12-15", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate52.setDate(localDate52);
        rate52.setCurrencyId(currency5.getId());
        rate52.setValue(new Double(9));
        rateRepository.save(rate52);

        Rate rate53 = new Rate();
        LocalDate localDate53 = LocalDate.parse("2020-12-16", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate53.setDate(localDate53);
        rate53.setCurrencyId(currency5.getId());
        rate53.setValue(new Double(9));
        rateRepository.save(rate53);

        Rate rate61 = new Rate();
        LocalDate localDate61 = LocalDate.parse("2020-12-14", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate61.setDate(localDate61);
        rate61.setCurrencyId(currency6.getId());
        rate61.setValue(new Double(2));
        rateRepository.save(rate61);

        Rate rate62 = new Rate();
        LocalDate localDate62 = LocalDate.parse("2020-12-15", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate62.setDate(localDate62);
        rate62.setCurrencyId(currency6.getId());
        rate62.setValue(new Double(17));
        rateRepository.save(rate62);

        Rate rate63 = new Rate();
        LocalDate localDate63 = LocalDate.parse("2020-12-16", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rate63.setDate(localDate63);
        rate63.setCurrencyId(currency6.getId());
        rate63.setValue(new Double(2));
        rateRepository.save(rate63);
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
