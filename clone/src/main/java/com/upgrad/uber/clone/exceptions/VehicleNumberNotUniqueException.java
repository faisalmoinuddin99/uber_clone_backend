package com.upgrad.uber.clone.exceptions ;

import java.io.Serial;

public class VehicleNumberNotUniqueException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    public VehicleNumberNotUniqueException(String exception) {
        super(exception);
    }
}
