package com.techstore.service.ICustomerService;

import com.techstore.model.account.Account;
import com.techstore.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> list(Pageable pageable, String search);
    void saveCustomer(Customer customer);
    Customer findCustomerById(int id);
    void deleteCustomerById(int id);
    Customer findByAccount(Account account);
}
