package com.techstore.service.IOrderProductService;

import com.techstore.model.order.OrderProduct;

import java.util.List;

public interface IOrderProductService {
    List<OrderProduct> findAll();
    OrderProduct findOrderProductById(int id);
    List<OrderProduct> findListById(int id);
    void saveOrderProduct(OrderProduct orderProduct);
    void removeOrderProductById(int id);
    void removeListOrderProductById(int id);
}
