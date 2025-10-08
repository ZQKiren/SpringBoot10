package com.cybersoft.springboot10.service;

import com.cybersoft.springboot10.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {

    Page<Employee> getAllEmployees(Pageable pageable);

    Page<Employee> getEmployeesByDepartment(String department, Pageable pageable);

    Page<Employee> getEmployeesBySalaryRange(int minSalary, int maxSalary, Pageable pageable);

    Employee addEmployee(Employee employee);
}
