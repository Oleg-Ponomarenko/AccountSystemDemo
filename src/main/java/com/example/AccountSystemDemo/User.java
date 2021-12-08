package com.example.AccountSystemDemo;

import java.util.Objects;

public class User {
    private String username;
    private String password;
    private int age;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    User(String username, String password, int age) {
        this.username = username;
        this.age = age;
    }
}
