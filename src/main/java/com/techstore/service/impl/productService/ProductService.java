package com.techstore.service.impl.productService;

import com.techstore.model.product.Product;
import com.techstore.repository.productRepository.IProductRepository;
import com.techstore.service.IProductService.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findAllProductById(int id, Pageable pageable) {
        return productRepository.findProductsByCategoriesId(id, pageable);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void remove(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Page<Product> findProductsByManufacturerId(int id, Pageable pageable) {
        return productRepository.findProductsByManufacturerId(id, pageable);
    }

}
