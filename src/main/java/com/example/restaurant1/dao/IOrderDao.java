package com.example.restaurant1.dao;

import com.example.restaurant1.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDao extends JpaRepository<Order,Integer> {

}
