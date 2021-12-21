package com.upgrad.uber.clone.dao ;


import com.upgrad.uber.clone.entities.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleCategoryDao extends JpaRepository<VehicleCategory, Integer> {
    VehicleCategory findByVehicleCategoryName(String category);
    VehicleCategory findByVehicleCategoryId(int categoryId);
}
