package com.upgrad.uber.clone.services;

import com.upgrad.uber.clone.entities.Vehicle;
import com.upgrad.uber.clone.exceptions.APIException;

import java.util.Date;
import java.util.List;

public interface VehicleService {
    public List<Vehicle> getAvailableVehicles(String categoryName, Date pickUpDate, Date dropDate, int locationId) throws APIException;
    public List<Vehicle> getAllVehicles() throws APIException;

}
