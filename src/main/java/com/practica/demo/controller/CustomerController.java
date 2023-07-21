package com.practica.demo.controller;

import com.practica.demo.models.Customer;
import com.practica.demo.service.CustomerService;
import com.practica.demo.service.ICustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private ICustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/{customerID}")
    public Customer fetchOneCustomer(@PathVariable("customerID") int customerID){
        return this.customerService.fetchOneCustomer(customerID);
    }

    @GetMapping
    public List<Customer> fetchAllCustomers(){
        return this.customerService.fetchAllCustomers();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return this.customerService.createCustomer(customer);
    }

    @PutMapping("/{customerID}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("customerID") int customerID){
        return this.customerService.updateCustomer(customer, customerID);
    }

    @DeleteMapping("/{customerID}")
    public void deleteCustomer(@PathVariable("customerID") int customerID){
        this.customerService.deleteCustomer(customerID);
    }
}
