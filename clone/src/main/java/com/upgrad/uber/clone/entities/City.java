package com.upgrad.uber.clone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cityId ;

    @Column(name="city_name",nullable = false)
    private String cityName;

    @JsonBackReference
    @OneToMany(mappedBy = "city",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private Set<Location> locations;

    public City(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public City() {

    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }


    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}


