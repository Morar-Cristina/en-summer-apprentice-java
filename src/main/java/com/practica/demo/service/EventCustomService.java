package com.practica.demo.service;

import com.practica.demo.models.DTOs.EventVenueEventTypeDTO;
import com.practica.demo.models.DTOs.TicketCategoryDTO;
import com.practica.demo.models.DTOs.VenueDTO;
import com.practica.demo.models.Event;
import com.practica.demo.models.EventType;
import com.practica.demo.models.TicketCategory;
import com.practica.demo.models.Venue;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventCustomService implements IEventCustomService{
    private IEventService eventService;
    private IEventTypeService eventTypeService;
    private IVenueService venueService;

    public EventCustomService(EventService eventService, EventTypeService eventTypeService, VenueService venueService){
        this.eventService = eventService;
        this.eventTypeService = eventTypeService;
        this.venueService = venueService;
    }

    @Override
    public Event createEvent(Event event, int locationID, int eventTypeID) {
        Venue venue = this.venueService.getVenueRepo().findById(locationID).get();
        EventType eventType = this.eventTypeService.getEventTypeRepo().findById(eventTypeID).get();
        event.setEventType(eventType);
        event.setLocation(venue);
        return this.eventService.createEvent(event);
    }

    @Override
    public Event fetchOneEvent(int locationID) {
        return this.eventService.fetchOneEvent(locationID);
    }

    private EventVenueEventTypeDTO convertToEventVenueEventTypeDTO(Event event, VenueDTO venueDTO, List<TicketCategoryDTO> ticketCategoryDTOS){
        return new EventVenueEventTypeDTO(
                event.getEventId(),
                venueDTO,
                event.getEventType().getEventTypeName(),
                event.getEventDescription(),
                event.getStartDate(),
                event.getEndDate(),
                ticketCategoryDTOS
        );
    }

    private List<TicketCategoryDTO> convertToTicketCategoryDTOList(List<TicketCategory> ticketCategoryList){
        return ticketCategoryList.stream()
                .map(ticketCategory -> new TicketCategoryDTO(ticketCategory.getTicketCategoryId(), ticketCategory.getTicketDescription(), ticketCategory.getTicketPrice()))
                .collect(Collectors.toList());
    }

    private VenueDTO convertToVenueDTO(Venue venue){
        return new VenueDTO(
                venue.getLocationId(),
                venue.getLocationName(),
                venue.getLocationType(),
                venue.getLocationCapacity()
        );
    }

    @Override
    public List<Event> fetchAllEvents() {
        return this.eventService.fetchAllEvents();
    }

    @Override
    public void deleteEvent(int eventID) {
        this.eventService.deleteEvent(eventID);
    }

    @Override
    public Event updateEvent(Event event, int eventID) {
        return this.eventService.updateEvent(event, eventID);
    }
}