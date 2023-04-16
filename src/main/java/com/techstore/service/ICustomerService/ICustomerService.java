package com.techstore.service.ICustomerService;

import com.techstore.model.customer.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void saveCustomer(Customer customer);
    Customer findCustomerById(int id);
    void deleteCustomerById(int id);
}
