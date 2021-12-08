package com.example.AccountSystemDemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InsufficientRightsException extends ResponseStatusException {
    InsufficientRightsException() {
        super(HttpStatus.FORBIDDEN, "Action forbidden");
    }
}
