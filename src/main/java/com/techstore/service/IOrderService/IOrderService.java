package com.techstore.service.IOrderService;

import com.techstore.model.order.Order;

import java.util.List;

public interface IOrderService {
    List<Order> findAll();
    Order findById(int id);
    void save(Order order);
    void deleteById(int id);
}
