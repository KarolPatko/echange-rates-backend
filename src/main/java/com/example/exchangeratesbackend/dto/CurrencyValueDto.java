package com.example.exchangeratesbackend.dto;

import com.example.exchangeratesbackend.entitie.projection.CurrencyValuesProjection;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.ArrayList;

public class CurrencyValueDto {
    private String name;
    private ArrayList<CurrencyValuesProjection> rates;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<CurrencyValuesProjection> getRates() {
        return rates;
    }

    public void setRates(ArrayList<CurrencyValuesProjection> rates) {
        this.rates = rates;
    }

    public CurrencyValueDto() {
    }

    public CurrencyValueDto(String name, ArrayList<CurrencyValuesProjection> rates) {
        this.name = name;
        this.rates = rates;
    }
}
