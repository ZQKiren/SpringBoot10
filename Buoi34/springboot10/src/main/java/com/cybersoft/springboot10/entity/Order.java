package com.cybersoft.springboot10.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "created_at")
    private LocalDate createdAt;
}
