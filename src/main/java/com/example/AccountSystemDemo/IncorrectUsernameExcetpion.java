package com.example.AccountSystemDemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class IncorrectUsernameExcetpion extends ResponseStatusException {
    IncorrectUsernameExcetpion() {
        super(HttpStatus.BAD_REQUEST, "Unsupported symbols in username");
    }
}
