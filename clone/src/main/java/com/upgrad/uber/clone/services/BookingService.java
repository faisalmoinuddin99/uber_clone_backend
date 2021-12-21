package com.upgrad.uber.clone.services ;


import com.upgrad.uber.clone.entities.Booking;
import com.upgrad.uber.clone.exceptions.APIException;
import com.upgrad.uber.clone.exceptions.InsufficientBalanceException;

public interface BookingService {
    Booking addBooking(Booking booking) throws APIException, InsufficientBalanceException;
}
