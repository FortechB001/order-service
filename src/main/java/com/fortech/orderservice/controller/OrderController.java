package com.fortech.orderservice.controller;

import com.fortech.orderservice.repository.OrderRepository;
import com.fortech.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class OrderController {

    private final OrderRepository orderRepository;

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderRepository orderRepository, OrderService orderService) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity<?> deployOrder(@RequestParam(name = "id") String productId,
                                         @RequestParam(name = "howMany") int howMany,
                                         @RequestParam(name = "daysToArriveInDeposit") Integer daysToArriveInDeposit,
                                         @RequestParam(name = "country") String country,
                                         @RequestParam(name = "daysToCustomer") Integer daysToCustomer) {

        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }
}
