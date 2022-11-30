package com.example.restaurant1.service;

import com.example.restaurant1.model.OrderListCook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderListCookService {
    Page<OrderListCook> getOrderListByCategoryAndStatus(String name, int status, Pageable pageable);
    Page<OrderListCook> getOrderList(Pageable pageable);
}
