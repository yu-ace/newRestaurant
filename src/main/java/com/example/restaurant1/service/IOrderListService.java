package com.example.restaurant1.service;

import com.example.restaurant1.model.OrderList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderListService {
    void newOrderList(int customerId,int dishesId,double price,int count);
    Page<OrderList> getOrderList(Pageable pageable);
    Page<OrderList> getOrderListByDishesId(int id, Pageable pageable);
    Page<OrderList> getOrderListByCustomerId(int id, Pageable pageable);
    Page<OrderList> getOrderListByStatus(int status,Pageable pageable);
    Page<OrderList> getOrderListByCookId(int cookId,Pageable pageable);
}
