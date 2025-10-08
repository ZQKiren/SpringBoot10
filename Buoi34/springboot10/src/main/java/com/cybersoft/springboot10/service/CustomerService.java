package com.cybersoft.springboot10.service;

import com.cybersoft.springboot10.dto.CustomerDTO;
import com.cybersoft.springboot10.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    List<CustomerDTO> getAllCustomersDTO();
}
