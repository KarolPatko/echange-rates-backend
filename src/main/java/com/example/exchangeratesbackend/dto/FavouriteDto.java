package com.example.exchangeratesbackend.dto;

public class FavouriteDto {
    private boolean isFavourite;

    public boolean getIsFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public FavouriteDto() {
    }

    public FavouriteDto(boolean isFavourite) {
        this.isFavourite = isFavourite;
    }
}
