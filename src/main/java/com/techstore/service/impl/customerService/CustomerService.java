package com.techstore.service.impl.customerService;

import com.techstore.model.account.Account;
import com.techstore.model.customer.Customer;
import com.techstore.repository.customerRepository.ICustomerRepository;
import com.techstore.service.ICustomerService.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Page<Customer> list(Pageable pageable, String search) {
        return customerRepository.findCustomerByNameCustomerContaining(pageable, search);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void deleteCustomerById(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findByAccount(Account account) {
        return customerRepository.findByAccount(account);
    }
}
