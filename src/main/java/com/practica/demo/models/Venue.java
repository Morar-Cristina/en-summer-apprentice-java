package com.practica.demo.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "venue")
public class Venue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private int locationId; // Primary key of type Integer

    @Column(name = "location_name", length = 30)
    private String locationName;

    @Column(name = "location_type", length = 30)
    private String locationType;

    @Column(name = "location_capacity")
    private Integer locationCapacity;

    // Constructors (including a default constructor for JPA)
    public Venue() {
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

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public Integer getLocationCapacity() {
        return locationCapacity;
    }

    public void setLocationCapacity(Integer locationCapacity) {
        this.locationCapacity = locationCapacity;
    }
}
