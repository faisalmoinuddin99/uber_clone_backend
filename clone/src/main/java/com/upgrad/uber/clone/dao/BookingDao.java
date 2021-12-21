package com.upgrad.uber.clone.dao;

import com.upgrad.uber.clone.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDao extends JpaRepository<Booking,Integer> {
}
