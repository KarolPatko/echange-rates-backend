package com.example.exchangeratesbackend.entitie.projection;

import java.time.LocalDate;

public interface CurrencyRateProjection {
    String getName();
    Double getValue();
    LocalDate getDate();
}
