package com.techstore.repository;

import com.techstore.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Integer> {
    Page<Customer>findCustomerByNameCustomerContaining(Pageable pageable,String search);
}
