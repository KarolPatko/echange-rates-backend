package com.example.exchangeratesbackend.entitie;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity()
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String currencyId;
    private Double value;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDate date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
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

    public Rate() {
    }

    public Rate(String id, String currencyId, Double value, LocalDate date) {
        this.id = id;
        this.currencyId = currencyId;
        this.value = value;
        this.date = date;
    }
}
