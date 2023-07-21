package com.practica.demo.service;

import com.practica.demo.models.Event;
import com.practica.demo.repository.EventRepository;

import java.util.List;

public interface IEventService {
    EventRepository getEventRepo();
    Event createEvent(Event event);
    Event fetchOneEvent(Integer eventID);
    List<Event> fetchAllEvents();
    void deleteEvent(Integer eventID);
    Event updateEvent(Event event, Integer eventID);
}