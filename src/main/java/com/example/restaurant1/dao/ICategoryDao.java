package com.example.restaurant1.dao;

import com.example.restaurant1.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryDao extends JpaRepository<Category,Integer> {

}
