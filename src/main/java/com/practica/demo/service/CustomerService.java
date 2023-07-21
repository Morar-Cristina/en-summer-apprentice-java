package com.practica.demo.service;

import com.practica.demo.models.Customer;
import com.practica.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{

    private CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo){
        this.customerRepo = customerRepo;
    }

    @Override
    public CustomerRepository getCustomerRepo() {
        return this.customerRepo;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public Customer fetchOneCustomer(Integer customerID) {
        return this.customerRepo.findById(customerID).get();
    }

    @Override
    public List<Customer> fetchAllCustomers() {
        return (List<Customer>) this.customerRepo.findAll();
    }

    @Override
    public void deleteCustomer(Integer customerID) {
        this.customerRepo.deleteById(customerID);
    }

    @Override
    public Customer updateCustomer(Customer customer, Integer customerID) {
        Customer updateCustomer=this.customerRepo.findById(customerID).get();
        updateCustomer.setCustomerName(customer.getCustomerName());
        updateCustomer.setCustomerEmail(customer.getCustomerEmail());
        return this.customerRepo.save(updateCustomer);
    }
}