package com.cybersoft.springboot10.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "customers")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_email")
    private String email;

    @Column(name = "customer_phone")
    private String phone;
}
