package com.practica.demo.controller;

import com.practica.demo.models.DTOs.EventOrdersDTO;
import com.practica.demo.models.Orders;
import com.practica.demo.service.IOrdersCustomService;
import com.practica.demo.service.OrdersCustomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    private IOrdersCustomService ordersCustomService;

    public OrdersController(OrdersCustomService ordersCompositeService){
        this.ordersCustomService = ordersCompositeService;
    }

    @GetMapping("/{orderID}")
    public Orders fetchOne(@PathVariable("orderID") int orderID){
        return this.ordersCustomService.fetchOneOrder(orderID);
    }

    @GetMapping
    public List<Orders> fetchAll(){
        return this.ordersCustomService.fetchAllOrders();
    }

    @GetMapping("/customer/{customerID}")
    public EventOrdersDTO fetchOneByCustomerID(@PathVariable("customerID") int customerID){
        return this.ordersCustomService.fetchOneByCustomerID(customerID);
    }

    @PostMapping("/customer/{customerID}/ticketCategory/{ticketCategoryID}")
    public Orders add(@RequestBody Orders orders, @PathVariable("customerID") int customerID,
                      @PathVariable("ticketCategoryID") int ticketCategoryID){
        return this.ordersCustomService.createOrder(orders, customerID, ticketCategoryID);
    }

    @PostMapping("/customer/{customerID}")
    public EventOrdersDTO addByCustomerID(@RequestBody Map<String, Object> requestBody,
                                          @PathVariable("customerID") int customerID){
        Integer eventID = (Integer) requestBody.get("eventID");
        Integer ticketCategoryID = (Integer) requestBody.get("ticketCategoryID");
        int numberOfTickets = (int) requestBody.get("numberOfTickets");

        return this.ordersCustomService.placeOrderByEventID(eventID.intValue(),
                ticketCategoryID.intValue(), customerID, numberOfTickets);
    }

    @PutMapping("/{orderID}")
    public Orders update(@RequestBody Orders orders, @PathVariable("orderID") int orderID){
        return this.ordersCustomService.updateOrder(orders, orderID);
    }

    @DeleteMapping("/{orderID}")
    public void delete(@PathVariable("orderID") int orderID){
        this.ordersCustomService.deleteOrder(orderID);
    }
}