package com.practica.demo.controller;

import com.practica.demo.models.EventType;
import com.practica.demo.service.IEventTypeService;
import org.springframework.web.bind.annotation.*;
import com.practica.demo.service.EventTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/eventType")
public class EventTypeController {
    private IEventTypeService eventTypeService;

    public EventTypeController(EventTypeService eventTypeService){
        this.eventTypeService = eventTypeService;
    }

    @GetMapping
    public List<EventType> fetchAll(){
        return this.eventTypeService.fetchAllEventType();
    }

    @GetMapping("/{eventTypeID}")
    public EventType fetchOneEventType(@PathVariable("eventTypeID") int eventTypeID){
        return this.eventTypeService.fetchOneEventType(eventTypeID);
    }

    @PostMapping
    public EventType createEventType(@RequestBody EventType eventType){
        return this.eventTypeService.createEventType(eventType);
    }

    @PutMapping("/{eventTypeID}")
    public EventType updateEventType(@RequestBody EventType eventType, @PathVariable("eventTypeID") int eventTypeID){
        return this.eventTypeService.updateEventType(eventType, eventTypeID);
    }

    @DeleteMapping("/{eventTypeID}")
    public void deleteEventType(@PathVariable("eventTypeID") int eventTypeID){
        this.eventTypeService.deleteEventType(eventTypeID);
    }
}