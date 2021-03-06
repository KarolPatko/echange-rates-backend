package com.example.exchangeratesbackend.repository;

import com.example.exchangeratesbackend.entitie.Rate;
import com.example.exchangeratesbackend.entitie.projection.CurrencyValuesProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.ArrayList;

public interface RateRepository extends JpaRepository<Rate, Long> {
    @Query("SELECT r.value as value, r.date as date, r.id as id FROM Rate r WHERE r.currencyId=:currId")
    ArrayList<CurrencyValuesProjection> findAllCurrencyValuesProjectedByCurrencyId(@Param("currId") long currencyId);
    Rate findByCurrencyIdAndDate(Long currencyId, LocalDate date);

    Rate getFirstByCurrencyIdOrderByDateDesc(Long currencyId);
}
