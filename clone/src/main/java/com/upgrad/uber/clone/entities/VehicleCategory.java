package com.upgrad.uber.clone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class VehicleCategory {
    @Id
    @Column(name="vehicle_category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleCategoryId;

    @Column(name="vehicle_category_name",nullable = false,unique = true)
    private String vehicleCategoryName;

    @JsonBackReference
    @OneToMany(mappedBy = "vehicleCategory",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<VehicleSubcategory> vehicleSubcategories;

    public VehicleCategory() {

    }

    public int getVehicleCategoryId() {
        return vehicleCategoryId;
    }

    public void setVehicleCategoryId(int vehicleCategoryId) {
        this.vehicleCategoryId = vehicleCategoryId;
    }

    public String getVehicleCategoryName() {
        return vehicleCategoryName;
    }

    public void setVehicleCategoryName(String vehicleCategoryName) {
        this.vehicleCategoryName = vehicleCategoryName;
    }

    public Set<VehicleSubcategory> getVehicleSubcategories() {
        return vehicleSubcategories;
    }

    public void setVehicleSubcategories(Set<VehicleSubcategory> vehicleSubcategories) {
        this.vehicleSubcategories = vehicleSubcategories;
    }

    public VehicleCategory(int vehicleCategoryId, String vehicleCategoryName) {
        this.vehicleCategoryId = vehicleCategoryId;
        this.vehicleCategoryName = vehicleCategoryName;
    }

    @Override
    public String toString() {
        return "VehicleCategory{" +
                "vehicleCategoryId=" + vehicleCategoryId +
                ", vehicleCategoryName='" + vehicleCategoryName + '\'' +
                '}';
    }
}
