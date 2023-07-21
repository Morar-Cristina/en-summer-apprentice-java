package com.practica.demo.service;

import com.practica.demo.models.Venue;
import com.practica.demo.repository.VenueRepository;

import java.util.List;

public interface IVenueService {
    VenueRepository getVenueRepo();
    Venue createVenue(Venue venue);
    Venue fetchOneVenue(Integer locationID);
    List<Venue> fetchAllVenues();
    void deleteVenue(Integer locationID);
    Venue updateVenue(Venue venue, Integer locationID);
}