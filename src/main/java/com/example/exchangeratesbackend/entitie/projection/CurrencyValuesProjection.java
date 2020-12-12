package com.example.exchangeratesbackend.entitie.projection;

import java.time.LocalDate;

public interface CurrencyValuesProjection {
    Double getValue();
    LocalDate getDate();
}
