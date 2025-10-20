package com.cybersoft.springboot10.service.imp;

import com.cybersoft.springboot10.entity.Employees;
import com.cybersoft.springboot10.repository.EmployeeRepository;
import com.cybersoft.springboot10.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employees> getAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employees> getEmployeesByDepartment(String department, Pageable pageable) {
        return employeeRepository.findByDepartment(department, pageable);
    }

    @Override
    public Page<Employees> getEmployeesBySalaryRange(int minSalary, int maxSalary, Pageable pageable) {
        return employeeRepository.findBySalaryRange(minSalary, maxSalary, pageable);
    }

    @Override
    public Employees addEmployee(Employees employees) {
        return employeeRepository.save(employees);
    }
}
