package com.cybersoft.springboot10.controller;

import com.cybersoft.springboot10.entity.Employees;
import com.cybersoft.springboot10.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getAllEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "salary") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase("desc") 
            ? Sort.by(sortBy).descending() 
            : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Employees> employees = employeeService.getAllEmployees(pageable);
        
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<?> getEmployeesByDepartment(
            @PathVariable String department,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "salary") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDir) {
        
        Sort sort = sortDir.equalsIgnoreCase("desc") 
            ? Sort.by(sortBy).descending() 
            : Sort.by(sortBy).ascending();
        
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Employees> employees = employeeService.getEmployeesByDepartment(department, pageable);
        
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/salary-range")
    public ResponseEntity<?> getEmployeesBySalaryRange(
            @RequestParam int minSalary,
            @RequestParam int maxSalary,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "salary") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDir) {
        
        Sort sort = sortDir.equalsIgnoreCase("desc") 
            ? Sort.by(sortBy).descending() 
            : Sort.by(sortBy).ascending();
        
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Employees> employees = employeeService.getEmployeesBySalaryRange(minSalary, maxSalary, pageable);
        
        return ResponseEntity.ok(employees);
    }

    @PostMapping
    public ResponseEntity<?> addEmployee(@RequestBody Employees employees) {
        Employees savedEmployees = employeeService.addEmployee(employees);
        return ResponseEntity.ok("Thêm nhân viên thành công: " + savedEmployees.getName());
    }
}
