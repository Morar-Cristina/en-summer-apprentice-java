package com.practica.demo.controller;

import com.practica.demo.models.Event;
import com.practica.demo.service.EventService;
import com.practica.demo.service.IEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {
    private IEventService eventService;

    public EventController(EventService eventService){
        this.eventService=eventService;
    }

    @GetMapping("/{eventID}")
    public Event fetchOneEvent(@PathVariable("eventID") int eventID){
        return this.eventService.fetchOneEvent(eventID);
    }

    @GetMapping
    public List<Event> fetchAllEvents(){
        return this.eventService.fetchAllEvents();
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event){
        return this.eventService.createEvent(event);
    }

    @PutMapping("/{eventID}")
    public Event updateEvent(@RequestBody Event event, @PathVariable("eventID") int eventID){
        return this.eventService.updateEvent(event, eventID);
    }

    @DeleteMapping("/{eventID}")
    public void deleteEvent(@PathVariable("eventID") int eventID){
        this.eventService.deleteEvent(eventID);
    }
}
