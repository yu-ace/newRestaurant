package com.example.restaurant1.dao;

import com.example.restaurant1.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerDao extends JpaRepository<Customer,Integer> {

}
