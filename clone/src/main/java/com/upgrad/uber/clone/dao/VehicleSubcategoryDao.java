package com.upgrad.uber.clone.dao ;

import com.upgrad.uber.clone.entities.VehicleSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleSubcategoryDao extends JpaRepository<VehicleSubcategory, Integer> {
}
