package com.example.restaurant1.service.impl;

import com.example.restaurant1.dao.IOrderListCookDao;
import com.example.restaurant1.model.OrderListCook;
import com.example.restaurant1.service.IOrderListCookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderListCookService implements IOrderListCookService {

    @Autowired
    IOrderListCookDao orderListCookDao;

    @Override
    public Page<OrderListCook> getOrderListByCategoryAndStatus(String name, int status, Pageable pageable) {
        return orderListCookDao.findByCategoryNameAndStatus(name,status,pageable);
    }

    @Override
    public Page<OrderListCook> getOrderList(Pageable pageable) {
        return orderListCookDao.findAll(pageable);
    }
}
