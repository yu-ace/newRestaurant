package com.example.restaurant1.service.impl;

import com.example.restaurant1.dao.IOrderDao;
import com.example.restaurant1.model.Order;
import com.example.restaurant1.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {

    @Autowired
    IOrderDao orderDao;

    @Override
    public void newOrder(int customerId) {
        Order order = new Order();
        order.setCustomerId(customerId);
       // order.setTotal() todo;
        orderDao.save(order);
    }

    @Override
    public Page<Order> getOrderList(Pageable pageable) {
        return orderDao.findAll(pageable);
    }
}
