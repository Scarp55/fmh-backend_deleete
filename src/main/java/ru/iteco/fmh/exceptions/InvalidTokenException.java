package ru.iteco.fmh.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class InvalidTokenException extends RuntimeException{
    public InvalidTokenException() {
        super("ERR_INVALID_REFRESH");
    }
}
