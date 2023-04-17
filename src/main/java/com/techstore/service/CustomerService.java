package com.techstore.service;

import com.techstore.model.customer.Customer;
import com.techstore.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> list(Pageable pageable, String search) {
        return iCustomerRepository.findCustomerByNameCustomerContaining(pageable, search);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Customer findByID(int id) {
        return iCustomerRepository.findById(id).get();
    }
}
