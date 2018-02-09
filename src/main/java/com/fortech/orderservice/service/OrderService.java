package com.fortech.orderservice.service;

import com.fortech.orderservice.model.Order;
import com.fortech.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrderEntry(String productId, Integer quantity) {
        return orderRepository.save(new Order(productId, quantity));
    }
}
