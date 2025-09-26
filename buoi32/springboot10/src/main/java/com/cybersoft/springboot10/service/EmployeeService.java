package com.cybersoft.springboot10.service;

import com.cybersoft.springboot10.entity.Employees;
import com.cybersoft.springboot10.repository.EmployeeRepository;
import com.cybersoft.springboot10.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Object detailEmployee(int id){
        Optional<Employees> employees = employeeRepository.findById(id);
        if(employees.isPresent())
            return employees.get();
        else{
            BaseResponse response = new BaseResponse();
            response.setError("Employee not found");
            response.setStatus(404);

            return response;
        }
    }
}
