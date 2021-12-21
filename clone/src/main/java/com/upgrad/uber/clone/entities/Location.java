package com.upgrad.uber.clone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @Column(name = "location_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int locationId;

    @Column(name="location_name",nullable = false)
    private String locationName;

    @Column(nullable = false)
    private String address;

    @Column(length = 6,nullable = false)
    private int pincode;

    @JsonBackReference
    @OneToMany(mappedBy = "location",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private Set<Booking> bookings;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "city_id",nullable = false)
    private City city;

    @JsonBackReference
    @OneToMany(mappedBy = "location",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private Set<Vehicle> vehicles;

    public Location() {

    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Location(int locationId, String locationName, String address, int pincode, City city) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.address = address;
        this.pincode = pincode;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", locationName='" + locationName + '\'' +
                ", address='" + address + '\'' +
                ", pincode='" + pincode + '\'' +
                ", city=" + city +
                '}';
    }
}
