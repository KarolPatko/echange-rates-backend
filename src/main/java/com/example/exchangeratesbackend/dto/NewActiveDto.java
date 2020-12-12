package com.example.exchangeratesbackend.dto;

public class NewActiveDto {
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public NewActiveDto() {
    }

    public NewActiveDto(boolean active) {
        this.active = active;
    }
}
