package com.upgrad.uber.clone.dao;


import com.upgrad.uber.clone.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City, Integer> {
}
