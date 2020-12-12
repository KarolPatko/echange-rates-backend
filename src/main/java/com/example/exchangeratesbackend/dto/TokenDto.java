package com.example.exchangeratesbackend.dto;

public class TokenDto {
    private String jwt;
    private String refresh;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getRefresh() {
        return refresh;
    }

    public void setRefresh(String refresh) {
        this.refresh = refresh;
    }

    public TokenDto() {
    }

    public TokenDto(String jwt, String refresh) {
        this.jwt = jwt;
        this.refresh = refresh;
    }
}
