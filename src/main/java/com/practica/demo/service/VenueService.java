package com.practica.demo.service;

import com.practica.demo.models.Venue;
import com.practica.demo.repository.VenueRepository;

import java.util.List;

public class VenueService implements  IVenueService{

    private VenueRepository venueRepo;

    public VenueService(VenueRepository venueRepo) {
        this.venueRepo = venueRepo;
    }

    @Override
    public VenueRepository getVenueRepo() {
        return this.venueRepo;
    }

    @Override
    public Venue createVenue(Venue venue) {
        return this.venueRepo.save(venue);
    }

    @Override
    public Venue fetchOneVenue(Integer locationID) {
        return this.venueRepo.findById(locationID).get();
    }

    @Override
    public List<Venue> fetchAllVenues() {
        return (List<Venue>) this.venueRepo.findAll();
    }

    @Override
    public void deleteVenue(Integer locationID) {
        this.venueRepo.deleteById(locationID);
    }

    @Override
    public Venue updateVenue(Venue venue, Integer locationID) {
        Venue updateVenue =this.venueRepo.findById(locationID).get();
        updateVenue.setLocationName(venue.getLocationName());
        updateVenue.setLocationType(venue.getLocationType());
        updateVenue.setLocationCapacity(venue.getLocationCapacity());
        return this.venueRepo.save(updateVenue);
    }
}
