package com.example.AccountSystemDemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UsernameExistsException extends ResponseStatusException {
    UsernameExistsException() {
        super(HttpStatus.CONFLICT, "Username already exists");
    }
}
