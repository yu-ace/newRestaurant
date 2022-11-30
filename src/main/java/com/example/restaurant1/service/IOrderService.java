package com.example.restaurant1.service;

import com.example.restaurant1.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderService {
    Order newOrder(int customerId);
    Page<Order> getOrderList(Pageable pageable);
}
