package com.example.restaurant1.dao;

import com.example.restaurant1.model.OrderList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderListDao extends JpaRepository<OrderList,Integer> {
    OrderList findById(int id);
    Page<OrderList> findByCustomerId(int id,Pageable pageable);
    Page<OrderList> findByStatus(int status, Pageable pageable);
    Page<OrderList> findByCookId(int id,Pageable pageable);
    Page<OrderList> findByDishesId(int id,Pageable pageable);
    List<OrderList> findByCustomerId(int id);
}
