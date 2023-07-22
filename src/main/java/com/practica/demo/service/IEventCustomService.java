package com.practica.demo.service;


import com.practica.demo.models.DTOs.EventVenueEventTypeDTO;
import com.practica.demo.models.Event;

import java.util.List;

public interface IEventCustomService {
    Event createEvent(Event event, int venueID, int eventTypeID);
    Event fetchOneEvent(int eventID);
    List<Event> fetchAllEvents();
    void deleteEvent(int eventID);
    Event updateEvent(Event event, int eventID);
}