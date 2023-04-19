package com.techstore.repository.productRepository;

import com.techstore.model.product.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
    Manufacturer findManufacturerById(int id);
}
