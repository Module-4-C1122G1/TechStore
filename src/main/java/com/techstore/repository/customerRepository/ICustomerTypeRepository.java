package com.techstore.repository.customerRepository;

import com.techstore.model.customer.Customer;
import com.techstore.model.customer.TypeCustomer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerTypeRepository extends PagingAndSortingRepository<TypeCustomer,Integer> {
}
