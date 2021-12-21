package com.upgrad.uber.clone.services ;


import com.upgrad.uber.clone.dao.VehicleDao;
import com.upgrad.uber.clone.entities.Vehicle;
import com.upgrad.uber.clone.exceptions.VehicleNotFoundException;
import com.upgrad.uber.clone.exceptions.VehicleNumberNotUniqueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    VehicleDao vehicleDao;

    /**
     * This method interacts with the VehicleDao to store vehicle's data into the database.

     */

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

    /**
     * This method changes the availability_status field of the vehicle based on the input parameters.
     * If the availability_status =0, then the vehicle is not available for booking. Similarly,
     * if the availability_status =1, then the vehicle is available for booking.
     */

    @Override
    public Vehicle changeAvailability(int vehicleId, int availabilityStatus) throws VehicleNotFoundException {
        Vehicle vehicle = vehicleDao.findById(vehicleId).orElseThrow(
                ()-> new VehicleNotFoundException("Vehicle not found for Id " + vehicleId));

        vehicle.setAvailabilityStatus(availabilityStatus);
        return vehicleDao.save(vehicle);
    }
}
