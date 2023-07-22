package com.practica.demo.models.DTOs;

import java.math.BigDecimal;
import java.util.Date;

public class EventOrdersDTO {
    private int eventID;
    private Date timestamp;
    private int ticketCategoryID;
    private int numberOfTickets;
    private BigDecimal totalPrice;

    public EventOrdersDTO(int eventID, Date timestamp, int ticketCategoryID, int numberOfTickets, BigDecimal totalPrice) {
        this.eventID = eventID;
        this.timestamp = timestamp;
        this.ticketCategoryID = ticketCategoryID;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getTicketCategoryID() {
        return ticketCategoryID;
    }

    public void setTicketCategoryID(int ticketCategoryID) {
        this.ticketCategoryID = ticketCategoryID;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
