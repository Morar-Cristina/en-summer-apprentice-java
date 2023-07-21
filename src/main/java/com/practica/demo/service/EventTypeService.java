package com.practica.demo.service;

import com.practica.demo.models.EventType;
import com.practica.demo.repository.EventTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventTypeService implements IEventTypeService
{
    private EventTypeRepository eventTypeRepo;

    public EventTypeService(EventTypeRepository eventTypeRepo) {
        this.eventTypeRepo = eventTypeRepo;
    }

    @Override
    public EventTypeRepository getEventTypeRepo() {
        return this.eventTypeRepo;
    }

    @Override
    public EventType createEventType(EventType eventType) {
        return this.eventTypeRepo.save(eventType);
    }

    @Override
    public EventType fetchOneEventType(Integer eventTypeID) {
        return this.eventTypeRepo.findById(eventTypeID).get();
    }

    @Override
    public List<EventType> fetchAllEventType() {
        return (List <EventType>) this.eventTypeRepo.findAll();
    }

    @Override
    public void deleteEventType(Integer eventTypeID) {
        this.eventTypeRepo.deleteById(eventTypeID);
    }

    @Override
    public EventType updateEventType(EventType eventType, Integer eventTypeID) {
        EventType updateEventType=this.eventTypeRepo.findById(eventTypeID).get();
        updateEventType.setEventTypeName(eventType.getEventTypeName());
        return this.eventTypeRepo.save(updateEventType);
    }
}
