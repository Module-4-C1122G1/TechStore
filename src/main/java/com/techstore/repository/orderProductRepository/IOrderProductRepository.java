package com.techstore.repository.orderProductRepository;

import com.techstore.model.order.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IOrderProductRepository extends JpaRepository<OrderProduct, Integer> {
    List<OrderProduct> findOrderProductsByOrder_Id(int id);
    @Transactional
    void deleteAllByOrder_Id(int id);
}
