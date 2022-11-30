package com.example.restaurant1.dao;

import com.example.restaurant1.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITableDao extends JpaRepository<Table,Integer> {

}
