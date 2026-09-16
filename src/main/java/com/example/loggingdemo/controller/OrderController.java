package com.example.loggingdemo.controller;

import com.example.loggingdemo.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;
//
//    public OrderController(OrderService orderService) {
//        this.orderService = orderService;
//    }

    @PostMapping
    public ResponseEntity<String> createOrder(){
        log.warn("Waiting handler order in 5 seconds");
        orderService.createOrder();
        return ResponseEntity.ok("Order created successfully");
    }
}
