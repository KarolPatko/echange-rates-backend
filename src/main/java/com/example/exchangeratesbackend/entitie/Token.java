package com.example.exchangeratesbackend.entitie;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String jwt;
    private String refresh;
    private String available;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public Token() {
    }

    public Token(String id, String jwt, String refresh, String available) {
        this.id = id;
        this.jwt = jwt;
        this.refresh = refresh;
        this.available = available;
    }
}
