package com.upgrad.uber.clone.dao ;

import com.upgrad.uber.clone.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDao extends JpaRepository<Vehicle, Integer> {
    boolean existsByVehicleNumber(String VehicleNumber);
}
