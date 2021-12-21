package com.upgrad.uber.clone.exceptions;

import java.io.Serial;

public class UserNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    public UserNotFoundException(String exception) {
        super(exception);
    }
}
