package com.example.exchangeratesbackend.dto;

public class NewRoleDto {
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public NewRoleDto() {
    }

    public NewRoleDto(String role) {
        this.role = role;
    }
}
