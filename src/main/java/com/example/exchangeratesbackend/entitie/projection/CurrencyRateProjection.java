package com.example.exchangeratesbackend.entitie.projection;

import java.time.LocalDate;

public class CurrencyRateProjection {
    Long currencyId;
    String name;
    Double value;
    LocalDate date;

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

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

    public CurrencyRateProjection(Long currencyId, String name, Double value, LocalDate date) {
        this.currencyId = currencyId;
        this.name = name;
        this.value = value;
        this.date = date;
    }
}
