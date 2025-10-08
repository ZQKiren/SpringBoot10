package com.cybersoft.springboot10.service;

import com.cybersoft.springboot10.entity.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    Order addOrder(Order order);
    List<Order> getOrdersByDateRange(LocalDate startDate, LocalDate endDate);
    List<Order> getTop5OrdersByTotalAmount();
}
