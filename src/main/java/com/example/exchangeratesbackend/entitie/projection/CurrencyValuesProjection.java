package com.example.exchangeratesbackend.entitie.projection;

import java.time.LocalDate;

public interface CurrencyValuesProjection {
    Long getId();
    Double getValue();
    LocalDate getDate();
}
