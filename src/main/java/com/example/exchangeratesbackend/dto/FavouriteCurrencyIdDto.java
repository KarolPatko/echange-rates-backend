package com.example.exchangeratesbackend.dto;

public class FavouriteCurrencyIdDto {
    private Long currencyId;

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public FavouriteCurrencyIdDto(Long currencyId) {
        this.currencyId = currencyId;
    }

    public FavouriteCurrencyIdDto() {
    }
}
