package com.techstore.service.IProductService;

import com.techstore.model.product.Utilities;

import java.util.List;

public interface IUtilitiesService {
    List<Utilities> findAll();
    Utilities findById(int id);
}
