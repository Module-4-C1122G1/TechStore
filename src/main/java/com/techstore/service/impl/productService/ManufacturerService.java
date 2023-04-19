package com.techstore.service.impl.productService;

import com.techstore.model.product.Manufacturer;
import com.techstore.repository.productRepository.IManufacturerRepository;
import com.techstore.service.IProductService.IManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManufacturerService implements IManufacturerService {
    @Autowired
    private IManufacturerRepository manufacturerRepository;
    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer findById(int id) {
        return manufacturerRepository.findById(id).get();
    }
}
