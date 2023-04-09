package com.techstore.repository;

import com.techstore.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Integer> {
    Page<Product> findProductsByCategoriesId(int id, Pageable pageable);

    Page<Product> findProductsByManufacturerId(int id, Pageable pageable);
}
