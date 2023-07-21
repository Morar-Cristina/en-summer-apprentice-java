package com.practica.demo.service;

import com.practica.demo.models.EventType;
import com.practica.demo.repository.EventTypeRepository;

import java.util.List;

public interface IEventTypeService {
    EventTypeRepository getEventTypeRepo();
    EventType createEventType(EventType eventType);
    EventType fetchOneEventType(Integer eventTypeID);
    List<EventType> fetchAllEventType();
    void deleteEventType(Integer eventTypeID);
    EventType updateEventType(EventType eventType, Integer eventTypeID);
}
