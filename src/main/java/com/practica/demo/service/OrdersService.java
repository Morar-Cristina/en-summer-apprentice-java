package com.practica.demo.service;

import com.practica.demo.models.Orders;
import com.practica.demo.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService implements IOrdersService{

    private OrdersRepository ordersRepo;

    public OrdersService(OrdersRepository ordersRepo) {
        this.ordersRepo = ordersRepo;
    }

    @Override
    public OrdersRepository getOrdersRepo() {
        return this.ordersRepo;
    }

    @Override
    public Orders createOrder(Orders order) {
        return this.ordersRepo.save(order);
    }

    @Override
    public Orders fetchOneOrder(Integer orderID) {
        return this.ordersRepo.findById(orderID).get();
    }

    @Override
    public List<Orders> fetchAllOrders() {
        return (List<Orders>) this.ordersRepo.findAll();
    }

    @Override
    public void deleteOrder(Integer orderID) {
        this.ordersRepo.deleteById(orderID);
    }

    @Override
    public Orders updateOrder(Orders order, Integer orderID) {
        Orders updateOrder=this.ordersRepo.findById(orderID).get();
        updateOrder.setCustomer(order.getCustomer());
        updateOrder.setTicketCategory(order.getTicketCategory());
        updateOrder.setOrderedAt(order.getOrderedAt());
        updateOrder.setNumberOfTickets(order.getNumberOfTickets());
        updateOrder.setTotalPrice(order.getTotalPrice());
        return this.ordersRepo.save(updateOrder);
    }
}
