package com.example.restaurant1.dao;

import com.example.restaurant1.model.Dishes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDishesDao extends JpaRepository<Dishes,Integer> {
    Page<Dishes> findByCategoryId(int id, Pageable pageable);
    Dishes findById(int id);
    Dishes findByName(String name);
}
