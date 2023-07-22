package com.practica.demo.models.DTOs;

public class VenueDTO {
    private int locationID;
    private String location;
    private String type;
    private int capacity;

    public VenueDTO(int locationID, String location, String type, int capacity) {
        this.locationID = locationID;
        this.location = location;
        this.type = type;
        this.capacity = capacity;
    }

    public int getVenueID() {
        return locationID;
    }

    public void setVenueID(int locationID) {
        this.locationID = locationID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
