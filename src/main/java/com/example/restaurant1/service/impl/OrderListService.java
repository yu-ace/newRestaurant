package com.example.restaurant1.service.impl;

import com.example.restaurant1.dao.IOrderListDao;
import com.example.restaurant1.model.OrderList;
import com.example.restaurant1.service.IOrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderListService implements IOrderListService {

    @Autowired
    IOrderListDao orderListDao;

    @Override
    public void newOrderList(int customerId, int dishesId, double price, int count) {
        OrderList orderList = new OrderList();
        orderList.setCustomerId(customerId);
        orderList.setDishesId(dishesId);
        orderList.setPrice(price);
        orderList.setCount(count);
        orderList.setStatus(0);
        orderList.setTime(new Date());
        orderListDao.save(orderList);
    }

    @Override
    public void finialOrderList(int id,int cookId) {
        OrderList orderList = orderListDao.findById(id);
        orderList.setStatus(1);
        orderList.setCookId(cookId);
        orderListDao.save(orderList);
    }

    @Override
    public Page<OrderList> getOrderList(Pageable pageable) {
        return orderListDao.findAll(pageable);
    }

    @Override
    public Page<OrderList> getOrderListByDishesId(int id, Pageable pageable) {
        return orderListDao.findByDishesId(id,pageable);
    }

    @Override
    public Page<OrderList> getOrderListByCustomerId(int id, Pageable pageable) {
        return orderListDao.findByCustomerId(id,pageable);
    }

    @Override
    public Page<OrderList> getOrderListByStatus(int status, Pageable pageable) {
        return orderListDao.findByStatus(status,pageable);
    }

    @Override
    public Page<OrderList> getOrderListByCookId(int cookId, Pageable pageable) {
        return orderListDao.findByCookId(cookId,pageable);
    }

    @Override
    public List<OrderList> getOrderListByCustomerId(int id) {
        return orderListDao.findByCustomerId(id);
    }
}
