package com.cybersoft.springboot10.controller;

import com.cybersoft.springboot10.dto.CustomerDTO;
import com.cybersoft.springboot10.entity.Customers;
import com.cybersoft.springboot10.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody Customers customers) {
        Customers savedCustomers = customerService.addCustomer(customers);
        return new ResponseEntity<>(savedCustomers, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customers = customerService.getAllCustomersDTO();
        return ResponseEntity.ok(customers);
    }
}
