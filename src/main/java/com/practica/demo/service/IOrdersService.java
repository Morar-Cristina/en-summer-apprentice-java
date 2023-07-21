package com.practica.demo.service;

import com.practica.demo.models.Orders;
import com.practica.demo.repository.OrdersRepository;

import java.util.List;

public interface IOrdersService {
    OrdersRepository getOrdersRepo();
    Orders createOrder(Orders order);
    Orders fetchOneOrder(Integer orderID);
    List<Orders> fetchAllOrders();
    void deleteOrder(Integer orderID);
    Orders updateOrder(Orders order, Integer orderID);
}
