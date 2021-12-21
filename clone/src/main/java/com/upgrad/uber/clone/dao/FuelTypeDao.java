package com.upgrad.uber.clone.dao;


import com.upgrad.uber.clone.entities.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelTypeDao extends JpaRepository<FuelType, Integer> {
}
