package com.upgrad.uber.clone.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @Column(name = "booking_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;

    @Column(name="pickup_date",nullable = false)
    private LocalDateTime pickupDate;

    @Column(name="dropOff_date",nullable = false)
    private LocalDateTime dropOffDate;

    @Column(name="booking_date",nullable = false)
    private LocalDateTime bookingDate;

    @Column(nullable = false)
    private double amount;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "location_id",nullable = false)
    private Location location;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "vehicle_id",nullable = false)
    private Vehicle vehicle;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private Users user;

    public Booking(int bookingId, LocalDateTime pickupDate, LocalDateTime dropOffDate, LocalDateTime bookingDate, double amount, Location location, Vehicle vehicle, Users user) {
        this.bookingId = bookingId;
        this.pickupDate = pickupDate;
        this.dropOffDate = dropOffDate;
        this.bookingDate = bookingDate;
        this.amount = amount;
        this.location = location;
        this.vehicle = vehicle;
        this.user = user;
    }

public Booking() {}

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDateTime pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDateTime getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(LocalDateTime dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", pickupDate=" + pickupDate +
                ", dropOffDate=" + dropOffDate +
                ", bookingDate=" + bookingDate +
                ", amount=" + amount +
                ", location=" + location +
                ", vehicle=" + vehicle +
                ", user=" + user +
                '}';
    }
}
