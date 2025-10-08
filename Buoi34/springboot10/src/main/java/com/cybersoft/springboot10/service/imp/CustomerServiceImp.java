package com.cybersoft.springboot10.service.imp;

import com.cybersoft.springboot10.dto.CustomerDTO;
import com.cybersoft.springboot10.entity.Customer;
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
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomersDTO() {
        return customerRepository.findAll().stream()
                .map(customer -> new CustomerDTO(customer.getId(), customer.getName(), customer.getPhone()))
                .collect(Collectors.toList());
    }
}
