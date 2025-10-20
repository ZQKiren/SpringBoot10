package com.cybersoft.springboot10.repository;

import com.cybersoft.springboot10.entity.Employees;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {

    Page<Employees> findAll(Pageable pageable);

    Page<Employees> findByDepartment(String department, Pageable pageable);

    @Query("SELECT e FROM employees e WHERE e.salary BETWEEN :minSalary AND :maxSalary")
    Page<Employees> findBySalaryRange(@Param("minSalary") int minSalary, @Param("maxSalary") int maxSalary, Pageable pageable);
}
