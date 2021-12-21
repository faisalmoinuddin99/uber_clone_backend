package com.upgrad.uber.clone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class VehicleSubcategory {
    @Id
    @Column(name="vehicle_subcategory_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleSubcategoryId;


    @Column(name="vehicle_subcategory_name",nullable = false,unique = true)
    private String vehicleSubcategoryName;

    @Column(name="price_per_day",nullable = false)
    private double pricePerDay;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="vehicle_category_id",nullable = false)
    private VehicleCategory vehicleCategory;

    @JsonBackReference
    @OneToMany(mappedBy = "vehicleSubcategory",fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private Set<Vehicle> vehicles;

    public VehicleSubcategory() {

    }


    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public int getVehicleSubcategoryId() {
        return vehicleSubcategoryId;
    }

    public void setVehicleSubcategoryId(int vehicleSubcategoryId) {
        this.vehicleSubcategoryId = vehicleSubcategoryId;
    }

    public String getVehicleSubcategoryName() {
        return vehicleSubcategoryName;
    }

    public void setVehicleSubcategoryName(String vehicleSubcategoryName) {
        this.vehicleSubcategoryName = vehicleSubcategoryName;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public VehicleSubcategory(String vehicleSubcategoryName, double pricePerDay, VehicleCategory vehicleCategory) {
        this.vehicleSubcategoryName = vehicleSubcategoryName;
        this.pricePerDay = pricePerDay;
        this.vehicleCategory = vehicleCategory;
    }

    public VehicleSubcategory(int vehicleSubcategoryId, String vehicleSubcategoryName, double pricePerDay, VehicleCategory vehicleCategory) {
        this.vehicleSubcategoryId = vehicleSubcategoryId;
        this.vehicleSubcategoryName = vehicleSubcategoryName;
        this.pricePerDay = pricePerDay;
        this.vehicleCategory = vehicleCategory;
    }

    @Override
    public String toString() {
        return "VehicleSubcategory{" +
                "vehicleSubcategoryId=" + vehicleSubcategoryId +
                ", vehicleSubcategoryName='" + vehicleSubcategoryName + '\'' +
                ", pricePerDay=" + pricePerDay +
                ", vehicleCategory=" + vehicleCategory +
                '}';
    }
}
