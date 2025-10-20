package com.cybersoft.springboot10.service;

import com.cybersoft.springboot10.entity.Orders;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    Orders addOrder(Orders orders);
    List<Orders> getOrdersByDateRange(LocalDate startDate, LocalDate endDate);
    List<Orders> getTop5OrdersByTotalAmount();
}
