package com.company.mt.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundException extends ResponseStatusException {

    public NotFoundException(String reason) {
        super(HttpStatus.BAD_REQUEST, reason);
    }
}
