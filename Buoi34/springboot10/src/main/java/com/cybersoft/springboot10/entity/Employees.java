package com.cybersoft.springboot10.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "employees")
@Table
@Data
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_salary")
    private int salary;

    @Column(name = "employee_department")
    private String department;
}
