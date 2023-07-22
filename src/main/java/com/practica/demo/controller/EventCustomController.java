package com.practica.demo.controller;

import com.practica.demo.models.Event;
import com.practica.demo.service.EventCustomService;
import com.practica.demo.service.IEventCustomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventCustomController {
    private IEventCustomService eventCustomService;

    public EventCustomController(EventCustomService eventCustomService){
        this.eventCustomService = eventCustomService;
    }

    @GetMapping("/{eventID}")
    public Event fetchOne(@PathVariable("eventID") int eventID){
        return this.eventCustomService.fetchOneEvent(eventID);
    }

    @GetMapping
    public List<Event> fetchAll(){
        return this.eventCustomService.fetchAllEvents();
    }

    @PostMapping("/venue/{venueID}/eventType/{eventTypeID}")
    public Event add(@RequestBody Event event, @PathVariable("venueID") int venueID,
                     @PathVariable("eventTypeID") int eventTypeID){
        return this.eventCustomService.createEvent(event, venueID, eventTypeID);
    }

    @PutMapping("/{eventID}")
    public Event update(@RequestBody Event event, @PathVariable("eventID") int eventID){
        return this.eventCustomService.updateEvent(event, eventID);
    }

    @DeleteMapping("/{eventID}")
    public void delete(@PathVariable("eventID") int eventID){
        this.eventCustomService.deleteEvent(eventID);
    }
}