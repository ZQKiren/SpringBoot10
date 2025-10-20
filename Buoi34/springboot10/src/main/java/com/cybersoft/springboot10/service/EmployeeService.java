package com.cybersoft.springboot10.service;

import com.cybersoft.springboot10.entity.Employees;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {

    Page<Employees> getAllEmployees(Pageable pageable);

    Page<Employees> getEmployeesByDepartment(String department, Pageable pageable);

    Page<Employees> getEmployeesBySalaryRange(int minSalary, int maxSalary, Pageable pageable);

    Employees addEmployee(Employees employees);
}
