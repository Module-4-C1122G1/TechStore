package com.techstore.repository.productRepository;

import com.techstore.model.product.Utilities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUtilitiesRepository extends JpaRepository<Utilities, Integer> {
}
