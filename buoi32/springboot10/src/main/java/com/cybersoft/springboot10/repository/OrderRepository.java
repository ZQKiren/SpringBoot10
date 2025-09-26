package com.cybersoft.springboot10.repository;

import com.cybersoft.springboot10.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
}
