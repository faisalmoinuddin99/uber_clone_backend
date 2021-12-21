package com.upgrad.uber.clone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class FuelType {

    @Id
    @Column(name = "fuel_type_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int fuelTypeId;

    @Column(name="fuel_type",nullable = false,unique = true)
    private String fuelType;


    public FuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @JsonBackReference
    @OneToMany(mappedBy = "fuelType",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private Set<Vehicle> vehicles;

    public FuelType() {

    }

    public int getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(int fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public FuelType(int fuelTypeId, String fuelType) {
        this.fuelTypeId = fuelTypeId;
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "FuelType{" +
                "fuelTypeId=" + fuelTypeId +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
