package com.example.restaurant1.dao;

import com.example.restaurant1.model.OrderListCook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderListCookDao extends JpaRepository<OrderListCook,Integer> {
    Page<OrderListCook> findByCategoryNameAndStatus(String category, int status, Pageable pageable);
}
