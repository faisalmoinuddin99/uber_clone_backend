package com.upgrad.uber.clone.dao;

import com.upgrad.uber.clone.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationDao extends JpaRepository<Location,Integer> {
}
