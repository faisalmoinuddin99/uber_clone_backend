package com.upgrad.uber.clone.dao;

import com.upgrad.uber.clone.entities.Vehicle;
import com.upgrad.uber.clone.entities.VehicleSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List ;
import java.util.Optional;

public interface VehicleDao extends JpaRepository<Vehicle, Integer> {

    List<Vehicle> findByVehicleSubcategory(VehicleSubcategory vehicleSubcategory);
    Optional<Vehicle> findByVehicleNumber(String vehicleNumber);
    Optional<Vehicle> findByAvailabilityStatus(Integer id);
}