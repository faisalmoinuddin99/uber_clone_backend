package com.upgrad.uber.clone.dao ;



import com.upgrad.uber.clone.entities.Booking;
import com.upgrad.uber.clone.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingDao extends JpaRepository<Booking, Integer> {
    List<Booking> findByVehicleWithBooking(Vehicle vehicle);
}
