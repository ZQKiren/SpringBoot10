package com.cybersoft.springboot10.service.imp;

import com.cybersoft.springboot10.dto.CustomerDTO;
import com.cybersoft.springboot10.entity.Customers;
import com.cybersoft.springboot10.repository.CustomerRepository;
import com.cybersoft.springboot10.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customers addCustomer(Customers customers) {
        return customerRepository.save(customers);
    }

    @Override
    public List<CustomerDTO> getAllCustomersDTO() {
        return customerRepository.findAll().stream()
                .map(customers -> new CustomerDTO(customers.getId(), customers.getName(), customers.getPhone()))
                .collect(Collectors.toList());
    }
}
