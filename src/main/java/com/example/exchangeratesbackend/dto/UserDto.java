package com.example.exchangeratesbackend.dto;

public class UserDto {
    private Long id;
    private String name;
    private String lastName;
    private String login;
    private String role;
    private Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public UserDto() {
    }

    public UserDto(Long id, String name, String lastName, String login, String role, Boolean active) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.role = role;
        this.active = active;
    }
}
