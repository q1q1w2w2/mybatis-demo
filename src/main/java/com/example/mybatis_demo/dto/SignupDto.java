package com.example.mybatis_demo.dto;

import lombok.Data;

@Data
public class SignupDto {
    private String username;
    private String email;
    private String password;

    public SignupDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
