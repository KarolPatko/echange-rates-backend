package com.example.exchangeratesbackend.dto;

public class LoggedUserDataDto {
    private String jwt;
    private String refresh;
    private String role;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LoggedUserDataDto() {
    }

    public LoggedUserDataDto(String jwt, String refresh, String role) {
        this.jwt = jwt;
        this.refresh = refresh;
        this.role = role;
    }
}
