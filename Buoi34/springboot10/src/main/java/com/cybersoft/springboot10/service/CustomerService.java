package com.cybersoft.springboot10.service;

import com.cybersoft.springboot10.dto.CustomerDTO;
import com.cybersoft.springboot10.entity.Customers;

import java.util.List;

public interface CustomerService {
    Customers addCustomer(Customers customers);
    List<CustomerDTO> getAllCustomersDTO();
}
