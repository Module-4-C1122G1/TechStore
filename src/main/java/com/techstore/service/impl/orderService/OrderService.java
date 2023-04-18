package com.techstore.service.impl.orderService;

import com.techstore.model.order.Order;
import com.techstore.repository.orderRepository.IOrderRepository;
import com.techstore.service.IOrderService.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;
    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(int id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }
}
