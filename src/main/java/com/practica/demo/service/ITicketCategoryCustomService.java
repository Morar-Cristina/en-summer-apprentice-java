package com.practica.demo.service;


import com.practica.demo.models.TicketCategory;
import java.util.List;

public interface ITicketCategoryCustomService {
    TicketCategory fetchOneTicketCategory(int ticketCategoryID);
    List<TicketCategory> fetchAllTicketCategory();
    TicketCategory createTicketCategory(TicketCategory ticketCategory, int eventID);
    TicketCategory updateTicketCategory(TicketCategory ticketCategory, int ticketCategoryID);
    void deleteTicketCategory(int ticketCategoryID);
}