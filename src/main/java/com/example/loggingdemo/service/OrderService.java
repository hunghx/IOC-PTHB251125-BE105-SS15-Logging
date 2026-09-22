package com.example.loggingdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
//@Slf4j // tự sinh đối tượng logger
public class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);
    // cung cấp 1 phương thực tạo mới hóa đơn
    public void createOrder() {
        // tạo 1 mã định danh duy nhất cho hóa đơn
        String orderId = UUID.randomUUID().toString();
        // Để ghi log đc thì cần 1 đối tượng Logger
        log.error("Tạo hóa đơn cho đơn hàng có OrderId là : {}", orderId);
        log.warn("Tạo hóa đơn cho đơn hàng có OrderId là : {}", orderId);
        log.info("Tạo hóa đơn cho đơn hàng có OrderId là : {}", orderId);
        log.debug("Tạo hóa đơn cho đơn hàng có OrderId là : {}", orderId);
        log.trace("Tạo hóa đơn cho đơn hàng có OrderId là : {}", orderId);
    }
}
