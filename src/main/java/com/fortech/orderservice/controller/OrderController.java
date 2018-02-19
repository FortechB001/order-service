package com.fortech.orderservice.controller;

import com.fortech.orderservice.model.Order;
import com.fortech.orderservice.repository.OrderRepository;
import com.fortech.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderService orderService;
    private final RestTemplate restTemplate;

    @Autowired
    public OrderController(OrderRepository orderRepository, OrderService orderService, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
        this.restTemplate = restTemplate;
    }

    @PostMapping(value = "/make")
    public ResponseEntity<?> deployOrder(@RequestParam(name = "id") String productId,
                                         @RequestParam(name = "howMany") int howMany,
                                         @RequestParam(name = "daysToArriveInDeposit") Integer daysToArriveInDeposit,
                                         @RequestParam(name = "country") String country,
                                         @RequestParam(name = "daysToCustomer") Integer daysToCustomer) {

        if (orderService.createOrderEntry(productId, howMany) != null) {
            String url = "http://stock-service/stock/update?productId=" + productId + "&howMany=" + howMany;
            ResponseEntity<?> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, null,
                    new ParameterizedTypeReference<ResponseEntity>() {
                    });
            return new ResponseEntity<>("Your order was successfully sent", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("There was a problem completing your order", HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/all")
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping(value = "/testing")
    public ResponseEntity<?> testRestTemplate() {

        ResponseEntity<?> responseEntity = restTemplate.exchange("http://product-service/product/all",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Object>>() {
                });
        return responseEntity;
    }
}
