package com.example.exchangeratesbackend.dto;

public class FavouriteDto {
    private boolean isFavourite;

    public boolean getIsFavourite() {
        return isFavourite;
    }


    public void setIsFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public FavouriteDto() {
    }

    public FavouriteDto(boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

    @Override
    public String toString() {
        return "FavouriteDto{" +
                "isFavourite=" + isFavourite +
                '}';
    }
}
