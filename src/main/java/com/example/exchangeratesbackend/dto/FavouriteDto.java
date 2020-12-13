package com.example.exchangeratesbackend.dto;

public class FavouriteDto {
    private boolean isFavourite;

    public boolean isFavourite() {
        return isFavourite;
    }

    public FavouriteDto() {
    }

    public FavouriteDto(boolean isFavourite) {
        this.isFavourite = isFavourite;
    }
}
