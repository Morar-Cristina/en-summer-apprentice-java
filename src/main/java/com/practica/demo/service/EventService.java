package com.practica.demo.service;

import com.practica.demo.models.Event;
import com.practica.demo.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService implements IEventService{

    private EventRepository eventRepo;

    public EventService(EventRepository eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public EventRepository getEventRepo() {
        return this.eventRepo;
    }

    @Override
    public Event createEvent(Event event) {
        return this.eventRepo.save(event);
    }

    @Override
    public Event fetchOneEvent(Integer eventID) {
        return this.eventRepo.findById(eventID).get();
    }

    @Override
    public List<Event> fetchAllEvents() {
        return (List<Event>) this.eventRepo.findAll();
    }

    @Override
    public void deleteEvent(Integer eventID) {
        this.eventRepo.deleteById(eventID);
    }

    @Override
    public Event updateEvent(Event event, Integer eventID) {
        Event updateEvent=this.eventRepo.findById(eventID).get();
        updateEvent.setEventName(event.getEventName());
        updateEvent.setEventName(event.getEventDescription());
        updateEvent.setStartDate(event.getStartDate());
        updateEvent.setEndDate(event.getEndDate());
        updateEvent.setLocation(event.getLocation());
        updateEvent.setEventType(event.getEventType());
        return this.eventRepo.save(updateEvent);
    }
}