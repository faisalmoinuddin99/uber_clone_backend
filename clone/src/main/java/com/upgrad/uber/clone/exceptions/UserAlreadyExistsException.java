package com.upgrad.uber.clone.exceptions ;

import java.io.Serial;

public class UserAlreadyExistsException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    public UserAlreadyExistsException(String exception) {
        super(exception);
    }
}
