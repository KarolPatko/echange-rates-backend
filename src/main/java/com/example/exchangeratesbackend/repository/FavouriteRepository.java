package com.example.exchangeratesbackend.repository;

import com.example.exchangeratesbackend.dto.FavouriteCurrencyIdDto;
import com.example.exchangeratesbackend.entitie.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Long> {


    List<Favourite> findCurrencyIdByUserId(Long userId);

    Optional<Favourite> findByCurrencyIdAndAndUserId(Long currencyId, Long userId);
}
