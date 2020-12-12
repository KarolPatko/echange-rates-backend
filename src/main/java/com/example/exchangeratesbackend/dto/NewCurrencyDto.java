package com.example.exchangeratesbackend.dto;

public class NewCurrencyDto {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NewCurrencyDto() {
    }

    public NewCurrencyDto(String name) {
        this.name = name;
    }
}
