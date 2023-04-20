package com.techstore.service.IProductService;

import com.techstore.model.product.Manufacturer;

import java.util.List;

public interface IManufacturerService {
    List<Manufacturer> findAll();
    Manufacturer findById(int id);
    Manufacturer findManufacturerById(int id);
}
