package com.example.exchangeratesbackend.repository;

import com.example.exchangeratesbackend.entitie.Currency;
import com.example.exchangeratesbackend.entitie.projection.CurrencyRateProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    @Query("SELECT c.name as name, r.value as value, r.date as date FROM Currency c JOIN Rate r ON c.id = r.currencyId")
    List<CurrencyRateProjection> getAllProjectedBy();
    Currency findByName(String name);

    List<Currency> findAll();

    Optional<Currency> findById(Long id);

    @Query("SELECT c.name FROM Currency c WHERE c.id = ?1")
    String findNameById(Long currencyId);
}
