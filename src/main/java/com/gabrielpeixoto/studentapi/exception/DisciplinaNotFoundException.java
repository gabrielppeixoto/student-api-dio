package com.gabrielpeixoto.studentapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DisciplinaNotFoundException extends Exception{
    public DisciplinaNotFoundException(Long id)
    {
        super("Course not found with id " + id);
    }
}
