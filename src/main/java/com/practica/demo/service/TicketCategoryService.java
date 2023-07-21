package com.practica.demo.service;

import com.practica.demo.models.TicketCategory;
import com.practica.demo.repository.TicketCategoryRepository;

import java.util.List;

public class TicketCategoryService implements ITicketCategoryService{

    private TicketCategoryRepository ticketCategoryRepo;

    public TicketCategoryService(TicketCategoryRepository ticketCategoryRepo) {
        this.ticketCategoryRepo = ticketCategoryRepo;
    }

    @Override
    public TicketCategoryRepository getTicketCategoryRepo() {
        return this.ticketCategoryRepo;
    }

    @Override
    public TicketCategory createTicketCategory(TicketCategory ticketCategory) {
        return this.ticketCategoryRepo.save(ticketCategory);
    }

    @Override
    public TicketCategory fetchOneTicketCategory(Integer ticketCategoryID) {
        return this.ticketCategoryRepo.findById(ticketCategoryID).get();
    }

    @Override
    public List<TicketCategory> fetchAllTicketCategory() {
        return (List<TicketCategory>) this.ticketCategoryRepo.findAll();
    }

    @Override
    public void deleteTicketCategory(Integer ticketCategoryID) {
        this.ticketCategoryRepo.deleteById(ticketCategoryID);
    }

    @Override
    public TicketCategory updateTicketCategory(TicketCategory ticketCategory, Integer ticketCategoryID) {
        TicketCategory updateTicketCategory=this.ticketCategoryRepo.findById(ticketCategoryID).get();
        updateTicketCategory.setEvent(ticketCategory.getEvent());
        updateTicketCategory.setTicketDescription(ticketCategory.getTicketDescription());
        updateTicketCategory.setTicketPrice(ticketCategory.getTicketPrice());
        return this.ticketCategoryRepo.save(updateTicketCategory);
    }
}
