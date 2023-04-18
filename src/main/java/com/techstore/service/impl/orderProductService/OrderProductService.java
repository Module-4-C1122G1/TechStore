package com.techstore.service.impl.orderProductService;

import com.techstore.model.order.OrderProduct;
import com.techstore.repository.orderProductRepository.IOrderProductRepository;
import com.techstore.service.IOrderProductService.IOrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductService implements IOrderProductService {
    @Autowired
    private IOrderProductRepository orderProductRepository;
    @Override
    public List<OrderProduct> findAll() {
        return orderProductRepository.findAll();
    }

    @Override
    public OrderProduct findOrderProductById(int id) {
        return orderProductRepository.findById(id).get();
    }

    @Override
    public List<OrderProduct> findListById(int id) {
        return orderProductRepository.findOrderProductsByOrder_Id(id);
    }

    @Override
    public void saveOrderProduct(OrderProduct orderProduct) {
        orderProductRepository.save(orderProduct);
    }

    @Override
    public void removeOrderProductById(int id) {
        orderProductRepository.deleteById(id);
    }

    @Override
    public void removeListOrderProductById(int id) {
        orderProductRepository.deleteAllByOrder_Id(id);
    }
}
