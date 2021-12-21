package com.upgrad.uber.clone.dao;

import com.upgrad.uber.clone.entities.VehicleSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleSubcategoryDao extends JpaRepository<VehicleSubcategory, Integer> {

    List<VehicleSubcategory> findByVehicleSubcategoryId(int id);
}