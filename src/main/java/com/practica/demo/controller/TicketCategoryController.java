package com.practica.demo.controller;

import com.practica.demo.models.TicketCategory;
import com.practica.demo.service.ITicketCategoryCustomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ticketCategory")
public class TicketCategoryController {
    private ITicketCategoryCustomService ticketCategoryCustomService;


    public TicketCategoryController(ITicketCategoryCustomService ticketCategoryCustomService) {
        this.ticketCategoryCustomService = ticketCategoryCustomService;
    }

    @GetMapping("/{ticketCategoryID}")
    public TicketCategory fetchOne(@PathVariable("ticketCategoryID") int ticketCategoryID){
        return this.ticketCategoryCustomService.fetchOneTicketCategory(ticketCategoryID);
    }

    @GetMapping
    public List<TicketCategory> fetchAll(){
        return this.ticketCategoryCustomService.fetchAllTicketCategory();
    }

    @PostMapping("event/{eventID}")
    public TicketCategory createTicketCategory(@RequestBody TicketCategory ticketCategory, @PathVariable("eventID") int eventID){
        return this.ticketCategoryCustomService.createTicketCategory(ticketCategory,eventID);
    }

    @PutMapping("/{ticketCategoryID}")
    public TicketCategory updateTicketCategory(@RequestBody TicketCategory ticketCategory, @PathVariable("ticketCategoryID") int ticketCategoryID){
        return this.ticketCategoryCustomService.updateTicketCategory(ticketCategory, ticketCategoryID);
    }

    @DeleteMapping("/{ticketCategoryID}")
    public void deleteCategoryTicket(@PathVariable("ticketCategoryID") int ticketCategoryID){
        this.ticketCategoryCustomService.deleteTicketCategory(ticketCategoryID);
    }
}
