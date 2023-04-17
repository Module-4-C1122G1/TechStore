package com.techstore.repository.customerRepository;

import com.techstore.model.account.Account;
import com.techstore.model.customer.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
    Customer findByAccount(Account account);
}
