package com.example.exchangeratesbackend.service;


import com.example.exchangeratesbackend.dto.CurrencyValueDto;
import com.example.exchangeratesbackend.dto.FavouriteCurrencyIdDto;
import com.example.exchangeratesbackend.dto.FavouriteDto;
import com.example.exchangeratesbackend.entitie.Currency;
import com.example.exchangeratesbackend.entitie.Favourite;
import com.example.exchangeratesbackend.entitie.Rate;
import com.example.exchangeratesbackend.entitie.projection.CurrencyRateProjection;
import com.example.exchangeratesbackend.repository.CurrencyRepository;
import com.example.exchangeratesbackend.repository.FavouriteRepository;
import com.example.exchangeratesbackend.repository.RateRepository;
import com.example.exchangeratesbackend.repository.UserRepository;
import com.example.exchangeratesbackend.utils.JwtProperties;
import com.example.exchangeratesbackend.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavouriteService {
    @Autowired
    FavouriteRepository favouriteRepository;

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    RateRepository rateRepository;


    @Autowired
    UserRepository userRepository;

    public List<CurrencyRateProjection> getAllFavouriteCurrenciesObject(String authToken){
        String login = TokenUtils.getLogin(
                authToken.replace(JwtProperties.TOKEN_PREFIX, "")
        );
        Long userId;
        try {
            userId=userRepository.findUserByLogin(login).get().getId();
        }catch (Exception e){
            throw new NoSuchElementException("Nie ma takowego pośród nas");
        }
        List<Long> currIdList = favouriteRepository.findCurrencyIdByUserId(userId);
        List<Currency> currencies = new ArrayList<>();
        for(int i=0;i<currIdList.size();i++)
        {
           Optional<Currency> bufor=currencyRepository.findById(currIdList.get(i));
            if(bufor.isPresent()){
                currencies.add(bufor.get());
            }
        }

        List<CurrencyRateProjection> result = currencies.stream().map(currency -> addName(currency)).collect(Collectors.toList());
        return result;

    }

    private CurrencyRateProjection addName(Currency currency){
        CurrencyRateProjection currencyRateProjection = new CurrencyRateProjection();
        currencyRateProjection.setName(currency.getName());
        currencyRateProjection.setCurrencyId(currency.getId());
        Rate newestRate = rateRepository.getFirstByCurrencyIdOrderByDateDesc(currency.getId());

        if(newestRate != null){
            currencyRateProjection.setValue(newestRate.getValue());
            currencyRateProjection.setDate(newestRate.getDate());
        }
        else{
            currencyRateProjection.setValue(null);
            currencyRateProjection.setDate(null);
        }

        return currencyRateProjection;
    }


    public List<Long> getAllFavouriteCurrencies(String authToken){
        String login = TokenUtils.getLogin(
                authToken.replace(JwtProperties.TOKEN_PREFIX, "")
        );
        Long userId;
        try {
            userId=userRepository.findUserByLogin(login).get().getId();
        }catch (Exception e){
            throw new NoSuchElementException("Nie ma takowego pośród nas");
        }
        return favouriteRepository.findCurrencyIdByUserId(userId);

    }

    public void addOrDeleteFavourite(String authToken, FavouriteDto favouriteDto, Long currencyId){
        String login = TokenUtils.getLogin(
                authToken.replace(JwtProperties.TOKEN_PREFIX, "")
        );
        Long userId;
        try {
            userId=userRepository.findUserByLogin(login).get().getId();
        }catch (Exception e){
            throw new NoSuchElementException("Nie ma takowego pośród nas");
        }
        Optional<Favourite> checkIfPresent = favouriteRepository.findByCurrencyIdAndAndUserId(currencyId, userId);
        if(favouriteDto.getIsFavourite()){
            if(!checkIfPresent.isPresent()){
                favouriteRepository.save(new Favourite(userId, currencyId));
            }
        }else{
            if(checkIfPresent.isPresent()){
                favouriteRepository.delete(checkIfPresent.get());
            }
        }
    }
}
