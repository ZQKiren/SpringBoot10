package com.cybersoft.springboot10.controller;

import com.cybersoft.springboot10.entity.Orders;
import com.cybersoft.springboot10.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<?> addOrder(@RequestBody Orders orders) {
        Orders savedOrders = orderService.addOrder(orders);
        return new ResponseEntity<>(savedOrders, HttpStatus.CREATED);
    }

    @GetMapping("/date-range")
    public ResponseEntity<?> getOrdersByDateRange(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        List<Orders> orders = orderService.getOrdersByDateRange(start, end);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/top")
    public ResponseEntity<?> getTop5Orders() {
        List<Orders> topOrders = orderService.getTop5OrdersByTotalAmount();
        return ResponseEntity.ok(topOrders);
    }
}
