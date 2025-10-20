package com.cybersoft.springboot10.repository;

import com.cybersoft.springboot10.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    List<Orders> findByCreatedAtBetween(LocalDate startDate, LocalDate endDate);

    @Query(value = "SELECT o FROM orders o ORDER BY o.totalAmount DESC LIMIT 5")
    List<Orders> findTop5ByTotalAmountDesc();
}
