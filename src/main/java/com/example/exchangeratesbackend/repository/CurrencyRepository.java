package com.example.exchangeratesbackend.repository;

import com.example.exchangeratesbackend.entitie.Currency;
import com.example.exchangeratesbackend.entitie.projection.CurrencyRateProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    @Query("SELECT c.name as name, r.value as value, r.date as date FROM Currency c JOIN Rate r ON c.id = r.currencyId ORDER BY date DESC")
    List<CurrencyRateProjection> getAllProjectedBy();
    Currency findByName(String name);
}
