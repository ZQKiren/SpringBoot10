package com.cybersoft.springboot10.service;

import com.cybersoft.springboot10.entity.Orders;
import com.cybersoft.springboot10.entity.Products;
import com.cybersoft.springboot10.repository.OrderRepository;
import com.cybersoft.springboot10.repository.ProductRepository;
import com.cybersoft.springboot10.request.InsertOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public String insertOrder(InsertOrderRequest req){
        Orders orders = new Orders();
        orders.setName(req.getCustomerName());

        orderRepository.save(orders);

        List<Products> products = productRepository.findAllById(req.getProductId());

        for(Products p : products){
            p.setOrder(orders);
        }

        productRepository.saveAll(products);

        return "Tạo đơn hàng thành công!";
    }

    public List<Orders> getOrder(){
        return orderRepository.findAll();
    }
}
