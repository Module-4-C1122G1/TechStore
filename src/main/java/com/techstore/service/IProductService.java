package com.techstore.service;

import com.techstore.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Iterable<Product> findAll();

    Page<Product> findAllProductById(int id, Pageable pageable);

    Product findById(int id);

    void remove(int id);

    void save(Product product);

    Page<Product> findProductsByManufacturerId(int id, Pageable pageable);
}
