package com.example.restaurant1.service.impl;

import com.example.restaurant1.dao.IOrderDao;
import com.example.restaurant1.dao.IOrderListDao;
import com.example.restaurant1.model.Order;
import com.example.restaurant1.model.OrderList;
import com.example.restaurant1.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    IOrderDao orderDao;
    @Autowired
    IOrderListDao orderListDao;

    @Override
    public Order newOrder(int customerId) {
        Order order = new Order();
        order.setCustomerId(customerId);
        List<OrderList> orderList = orderListDao.findByCustomerId(customerId);
        double total = 0;
        for(OrderList orderList1 : orderList){
            total = total + (orderList1.getPrice() * orderList1.getCount());
        }
        order.setTotal(total);
        orderDao.save(order);
        return order;
    }

    @Override
    public Page<Order> getOrderList(Pageable pageable) {
        return orderDao.findAll(pageable);
    }
}
