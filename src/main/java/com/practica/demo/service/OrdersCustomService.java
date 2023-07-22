package com.practica.demo.service;

import com.practica.demo.models.Customer;
import com.practica.demo.models.DTOs.EventOrdersDTO;
import com.practica.demo.models.Orders;
import com.practica.demo.models.TicketCategory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class OrdersCustomService implements IOrdersCustomService{
    private IOrdersService ordersService;

    private ICustomerService customerService;
    private ITicketCategoryService ticketCategoryService;

    public OrdersCustomService(IOrdersService ordersService, ICustomerService customerService, ITicketCategoryService ticketCategoryService){
        this.customerService = customerService;
        this.ordersService = ordersService;
        this.ticketCategoryService = ticketCategoryService;
    }

    @Override
    public EventOrdersDTO fetchOneByCustomerID(int customerID){
        List<Orders> ordersList = this.ordersService.fetchAllOrders();
        for(Orders orders: ordersList){
            if(Objects.equals(orders.getCustomer().getCustomerId(), customerID)){
                return new EventOrdersDTO(
                        orders.getTicketCategory().getEvent().getEventId(),
                        orders.getOrderedAt(),
                        orders.getTicketCategory().getTicketCategoryId(),
                        orders.getNumberOfTickets(),
                        orders.getTotalPrice()
                );
            }
        }
        return null;
    }

    @Override
    public Orders createOrder(Orders orders, int customerID, int ticketCategoryID) {
        Customer customer = this.customerService.getCustomerRepo().findById(customerID).get();
        TicketCategory ticketCategory = this.ticketCategoryService.getTicketCategoryRepo().findById(ticketCategoryID).get();
        orders.setCustomer(customer);
        orders.setTicketCategory(ticketCategory);
        return this.ordersService.createOrder(orders);
    }

    @Override
    public EventOrdersDTO placeOrderByEventID(int eventID, int ticketCategoryID, int customerID, int numberOfTickets) {
        TicketCategory ticketCategory = this.ticketCategoryService.fetchOneTicketCategory(ticketCategoryID);
        BigDecimal totalPrice = ticketCategory.getTicketPrice();
        totalPrice = totalPrice.multiply(BigDecimal.valueOf(numberOfTickets));
        Orders orders = new Orders();
        orders.setOrderedAt(new Date());
        orders.setNumberOfTickets(numberOfTickets);
        orders.setTotalPrice(totalPrice);

        this.createOrder(orders, customerID, ticketCategoryID);
        return new EventOrdersDTO(
                eventID,
                orders.getOrderedAt(),
                ticketCategoryID,
                numberOfTickets,
                totalPrice
        );
    }

    @Override
    public Orders fetchOneOrder(int orderID) {
        return this.ordersService.fetchOneOrder(orderID);
    }

    @Override
    public List<Orders> fetchAllOrders() {
        return this.ordersService.fetchAllOrders();
    }

    @Override
    public Orders updateOrder(Orders orders, int orderID) {
        return this.ordersService.updateOrder(orders, orderID);
    }

    @Override
    public void deleteOrder(int orderID) {
        this.ordersService.deleteOrder(orderID);
    }
}