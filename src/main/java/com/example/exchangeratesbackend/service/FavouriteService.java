package com.example.exchangeratesbackend.service;


import com.example.exchangeratesbackend.dto.FavouriteCurrencyIdDto;
import com.example.exchangeratesbackend.dto.FavouriteDto;
import com.example.exchangeratesbackend.entitie.Favourite;
import com.example.exchangeratesbackend.repository.CurrencyRepository;
import com.example.exchangeratesbackend.repository.FavouriteRepository;
import com.example.exchangeratesbackend.repository.UserRepository;
import com.example.exchangeratesbackend.utils.JwtProperties;
import com.example.exchangeratesbackend.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FavouriteService {
    @Autowired
    FavouriteRepository favouriteRepository;

    @Autowired
    UserRepository userRepository;

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
        List<Long> result = new ArrayList<>();
        List<Favourite> favouritesList= favouriteRepository.findCurrencyIdByUserId(userId);
        for(int i=0;i<favouritesList.size();i++)
        {
            result.add(favouritesList.get(i).getCurrencyId());
        }
        return result;

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
