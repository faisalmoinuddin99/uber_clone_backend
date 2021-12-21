package com.upgrad.uber.clone.dao;

import com.upgrad.uber.clone.entities.Vehicle;
import com.upgrad.uber.clone.entities.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleCategoryDao extends JpaRepository<VehicleCategory,Integer> {
    public VehicleCategory findByVehicleCategoryId(int id);
}
