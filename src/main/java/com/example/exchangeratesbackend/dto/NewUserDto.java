package com.example.exchangeratesbackend.dto;

public class NewUserDto {
    private String login;
    private String lastName;
    private String password;
    private String name;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NewUserDto() {
    }

    public NewUserDto(String login, String lastName, String password, String name) {
        this.login = login;
        this.lastName = lastName;
        this.password = password;
        this.name = name;
    }
}
