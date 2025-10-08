package com.cybersoft.springboot10.repository;

import com.cybersoft.springboot10.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findByDepartment(String department, Pageable pageable);

    @Query("SELECT e FROM employees e WHERE e.salary BETWEEN :minSalary AND :maxSalary")
    Page<Employee> findBySalaryRange(@Param("minSalary") int minSalary, @Param("maxSalary") int maxSalary, Pageable pageable);
}
