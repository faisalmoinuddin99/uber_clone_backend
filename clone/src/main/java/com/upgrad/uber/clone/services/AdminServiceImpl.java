package com.upgrad.uber.clone.services;

import com.upgrad.uber.clone.dao.BookingDao;
import com.upgrad.uber.clone.dao.VehicleDao;
import com.upgrad.uber.clone.entities.Booking;
import com.upgrad.uber.clone.entities.Vehicle;
import com.upgrad.uber.clone.exceptions.VehicleNotFoundException;
import com.upgrad.uber.clone.exceptions.VehicleNumberNotUniqueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    VehicleDao vehicleDao;
    @Override
    public Vehicle registerVehicle(Vehicle vehicle) throws VehicleNumberNotUniqueException {
        boolean testVehicleNumber = vehicleDao.existsByVehicleNumber(vehicle.getVehicleNumber());
        if (testVehicleNumber) {
            throw new VehicleNumberNotUniqueException("Vehicle Number Already Exists");
        }
        Vehicle savedVehicle = vehicleDao.save(vehicle);
        savedVehicle.setAvailabilityStatus(1);
        return savedVehicle;
    }

    @Override
    public Vehicle changeAvailability(int vehicleId, int availabilityStatus) throws VehicleNotFoundException {
        Vehicle vehicle = vehicleDao.findById(vehicleId).orElseThrow(
                ()-> new VehicleNotFoundException("Vehicle not found for Id " + vehicleId));

        vehicle.setAvailabilityStatus(availabilityStatus);
        return vehicleDao.save(vehicle);
    }
}
