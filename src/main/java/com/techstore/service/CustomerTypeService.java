package com.techstore.service;

import com.techstore.model.customer.TypeCustomer;
import com.techstore.repository.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService{
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<TypeCustomer> list() {
        return (List<TypeCustomer>) iCustomerTypeRepository.findAll();
    }
}
