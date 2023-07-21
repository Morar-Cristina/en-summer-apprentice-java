package com.practica.demo.service;

import com.practica.demo.models.TicketCategory;
import com.practica.demo.repository.TicketCategoryRepository;

import java.util.List;

public interface ITicketCategoryService {
    TicketCategoryRepository getTicketCategoryRepo();
    TicketCategory createTicketCategory (TicketCategory ticketCategory);
    TicketCategory fetchOneTicketCategory(Integer ticketCategoryID);
    List<TicketCategory> fetchAllTicketCategory();
    void deleteTicketCategory(Integer ticketCategoryID);
    TicketCategory updateTicketCategory(TicketCategory ticketCategory, Integer ticketCategoryID);
}
