package com.cybersoft.springboot10.controller;

import com.cybersoft.springboot10.request.InsertOrderRequest;
import com.cybersoft.springboot10.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<?> getOrder(){
        return ResponseEntity.ok(orderService.getOrder());
    }

    @PostMapping
    public ResponseEntity<?> insertOrder(@RequestBody InsertOrderRequest req){
        return ResponseEntity.ok(orderService.insertOrder(req));
    }
}
