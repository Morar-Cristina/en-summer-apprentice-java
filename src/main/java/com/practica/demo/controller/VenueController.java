package com.practica.demo.controller;

import com.practica.demo.models.Venue;
import com.practica.demo.service.IVenueService;
import com.practica.demo.service.VenueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venue")
public class VenueController {
    private IVenueService venueService;

    public VenueController(VenueService venueService){
        this.venueService = venueService;
    }

    @GetMapping("/{venueID}")
    public Venue fetchOneVenue(@PathVariable("venueID") int locationID){
        return this.venueService.fetchOneVenue(locationID);
    }

    @GetMapping
    public List<Venue> fetchAllVenues(){
        return this.venueService.fetchAllVenues();
    }

    @PostMapping
    public Venue createVenue(@RequestBody Venue venue){
        return this.venueService.createVenue(venue);
    }

    @PutMapping("/{venueID}")
    public Venue updateVenue(@RequestBody Venue venue, @PathVariable("venueID") int locationID){
        return this.venueService.updateVenue(venue, locationID);
    }

    @DeleteMapping("/{venueID}")
    public void deleteVenue(@PathVariable("venueID") int locationID){
        this.venueService.deleteVenue(locationID);
    }
}