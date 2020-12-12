package com.example.exchangeratesbackend.dto;

import com.example.exchangeratesbackend.entitie.projection.CurrencyValuesProjection;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CurrencyValueDto {
    private String name;
    private List<CurrencyValuesProjection> rates;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CurrencyValuesProjection> getRates() {
        return rates;
    }

    public void setRates(List<CurrencyValuesProjection> rates) {
        this.rates = rates;
    }

    public CurrencyValueDto() {
    }

    public CurrencyValueDto(String name, List<CurrencyValuesProjection> rates) {
        this.name = name;
        this.rates = rates;
    }
}
