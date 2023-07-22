package com.practica.demo.service;

import com.practica.demo.models.Event;
import com.practica.demo.models.TicketCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketCategoryCustomService implements ITicketCategoryCustomService{
    private ITicketCategoryService ticketCategoryService;
    private IEventService eventService;

    public TicketCategoryCustomService(TicketCategoryService ticketCategoryService, EventService eventService) {
        this.ticketCategoryService = ticketCategoryService;
        this.eventService = eventService;
    }

    @Override
    public TicketCategory fetchOneTicketCategory(int ticketCategoryID) {
        return ticketCategoryService.fetchOneTicketCategory(ticketCategoryID);
    }

    @Override
    public List<TicketCategory> fetchAllTicketCategory() {
        return this.ticketCategoryService.fetchAllTicketCategory();
    }

    @Override
    public TicketCategory createTicketCategory(TicketCategory ticketCategory, int eventID) {
        Event event=this.eventService.getEventRepo().findById(eventID).get();
        ticketCategory.setEvent(event);
        return this.ticketCategoryService.createTicketCategory(ticketCategory);
    }

    @Override
    public TicketCategory updateTicketCategory(TicketCategory ticketCategory, int ticketCategoryID) {
        return this.ticketCategoryService.updateTicketCategory(ticketCategory, ticketCategoryID);
    }

    @Override
    public void deleteTicketCategory(int ticketCategoryID) {
        this.ticketCategoryService.deleteTicketCategory(ticketCategoryID);
    }
}
