package com.practica.demo.service;

import com.practica.demo.models.Customer;
import com.practica.demo.repository.CustomerRepository;

import java.util.List;

public interface ICustomerService {
    CustomerRepository getCustomerRepo();
    Customer createCustomer(Customer customer);
    Customer fetchOneCustomer(Integer customerID);
    List<Customer> fetchAllCustomers();
    void deleteCustomer(Integer customerID);
    Customer updateCustomer(Customer customer, Integer customerID);
}