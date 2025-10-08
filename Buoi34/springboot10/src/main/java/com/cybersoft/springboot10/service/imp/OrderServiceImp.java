package com.cybersoft.springboot10.service.imp;

import com.cybersoft.springboot10.entity.Order;
import com.cybersoft.springboot10.repository.OrderRepository;
import com.cybersoft.springboot10.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersByDateRange(LocalDate startDate, LocalDate endDate) {
        return orderRepository.findByCreatedAtBetween(startDate, endDate);
    }

    @Override
    public List<Order> getTop5OrdersByTotalAmount() {
        return orderRepository.findTop5ByTotalAmountDesc();
    }
}
