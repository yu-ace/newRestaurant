package com.example.restaurant1.dao;

import com.example.restaurant1.model.OrderList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderListDao extends JpaRepository<OrderList,Integer> {
    Page<OrderList> findByCustomerId(int id,Pageable pageable);
    Page<OrderList> findByStatus(int status, Pageable pageable);
    Page<OrderList> findByCookId(int id,Pageable pageable);
    Page<OrderList> findByDishesId(int id,Pageable pageable);
}
