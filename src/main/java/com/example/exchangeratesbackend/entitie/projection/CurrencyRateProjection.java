package com.example.exchangeratesbackend.entitie.projection;

import java.time.LocalDate;

public class CurrencyRateProjection {
    String name;
    Double value;
    LocalDate date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public CurrencyRateProjection() {
    }

    public CurrencyRateProjection(String name, Double value, LocalDate date) {
        this.name = name;
        this.value = value;
        this.date = date;
    }
}
