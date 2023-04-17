package com.techstore.service;

import com.techstore.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> list(Pageable pageable,String search);
    void save(Customer customer);
    void delete(int id);
    Customer findByID(int id);
}
