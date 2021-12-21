package com.upgrad.uber.clone.services;

import com.upgrad.uber.clone.entities.Booking;
import com.upgrad.uber.clone.entities.Vehicle;
import com.upgrad.uber.clone.exceptions.VehicleNotFoundException;
import com.upgrad.uber.clone.exceptions.VehicleNumberNotUniqueException;

public interface AdminService {
    Vehicle registerVehicle(Vehicle vehicle) throws VehicleNumberNotUniqueException;

    Vehicle changeAvailability(int vehicleId, int availabilityStatus) throws VehicleNotFoundException;
}