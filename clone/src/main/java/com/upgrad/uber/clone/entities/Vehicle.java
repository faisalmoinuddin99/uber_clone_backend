package com.upgrad.uber.clone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @Column(name = "vehicle_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleId;

    @Column(name="vehicle_model",nullable = false)
    private String vehicleModel;

    @Column(name="vehicle_number",length = 10,nullable = false)
    private String vehicleNumber;


    @Column(nullable = false)
    private String color;

    @Column(name="availability_status",length = 1,nullable = false)
    private int availabilityStatus;

    @Column(name="vehicle_image_url",nullable = false)
    private String vehicleImageUrl;

    @JsonBackReference
    @OneToMany(mappedBy = "vehicle",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private Set<Booking> bookings;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "fuel_type_id",nullable = false)
    private FuelType fuelType;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "location_id",nullable = false)
    private Location location;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "vehicle_subcategory_id",nullable = false)
    private VehicleSubcategory vehicleSubcategory;

    public Vehicle(String VehicleModel, String VehicleNumber, VehicleSubcategory vehicleSubcategory, String color, Location location, FuelType fuelType, int availabilityStatus, String imageUrl) {

        this.vehicleModel=VehicleModel;
        this.vehicleNumber=VehicleNumber;
        this.vehicleSubcategory=vehicleSubcategory;
        this.color=color;
        this.location=location;
        this.fuelType=fuelType;
        this.availabilityStatus=availabilityStatus;
        this.vehicleImageUrl=imageUrl;
    }

    public Vehicle() {

    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(int availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getVehicleImageUrl() {
        return vehicleImageUrl;
    }

    public void setVehicleImageUrl(String vehicleImageUrl) {
        this.vehicleImageUrl = vehicleImageUrl;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public VehicleSubcategory getVehicleSubcategory() {
        return vehicleSubcategory;
    }

    public void setVehicleSubcategory(VehicleSubcategory vehicleSubcategory) {
        this.vehicleSubcategory = vehicleSubcategory;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", color='" + color + '\'' +
                ", availabilityStatus=" + availabilityStatus +
                ", vehicleImageUrl='" + vehicleImageUrl + '\'' +
                ", fuelType=" + fuelType +
                ", location=" + location +
                ", vehicleSubcategory=" + vehicleSubcategory +
                '}';
    }

}
