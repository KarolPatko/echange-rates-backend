package com.example.exchangeratesbackend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class NewRateDto {
    private String name;
    private Double value;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDate date;

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

    public NewRateDto() {
    }

    public NewRateDto(String name, Double value, LocalDate date) {
        this.name = name;
        this.value = value;
        this.date = date;
    }
}
