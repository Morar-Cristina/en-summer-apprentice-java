package com.practica.demo.service;

import com.practica.demo.models.DTOs.EventOrdersDTO;
import com.practica.demo.models.Orders;
import java.util.List;

public interface IOrdersCustomService {
    Orders createOrder(Orders orders, int customerID, int ticketCategoryID);

    EventOrdersDTO placeOrderByEventID(int eventID, int ticketCategoryID, int customerID, int numberOfTicketsID);
    EventOrdersDTO fetchOneByCustomerID(int customerID);
    Orders fetchOneOrder(int orderID);
    List<Orders> fetchAllOrders();
    Orders updateOrder(Orders orders, int orderID);
    void deleteOrder(int orderID);
}