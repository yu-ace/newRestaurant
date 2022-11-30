package com.example.restaurant1.service;

import com.example.restaurant1.model.Dishes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDishesService {
    void newDishes(String name,double price,int categoryId);
    Dishes getDishesById(int id);
    Dishes getDishesByName(String name);
    Page<Dishes> getDishesList(Pageable pageable);
    Page<Dishes> getDishesListByCategoryId(int id,Pageable pageable);
}
