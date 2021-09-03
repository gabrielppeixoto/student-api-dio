package com.gabrielpeixoto.studentapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SalaNotFoundException extends Exception {
    public SalaNotFoundException(Long id)
    {
        super("Room not found with id " + id);
    }
}
