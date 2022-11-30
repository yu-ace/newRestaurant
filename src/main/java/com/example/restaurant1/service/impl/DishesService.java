package com.example.restaurant1.service.impl;

import com.example.restaurant1.dao.IDishesDao;
import com.example.restaurant1.model.Dishes;
import com.example.restaurant1.service.IDishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DishesService implements IDishesService {

    @Autowired
    IDishesDao dishesDao;

    @Override
    public void newDishes(String name, double price, int categoryId) {
        Dishes dishes = new Dishes();
        dishes.setName(name);
        dishes.setPrice(price);
        dishes.setCategoryId(categoryId);
        dishesDao.save(dishes);
    }

    @Override
    public Dishes getDishesById(int id) {
        return dishesDao.findById(id);
    }

    @Override
    public Dishes getDishesByName(String name) {
        return dishesDao.findByName(name);
    }

    @Override
    public Page<Dishes> getDishesList(Pageable pageable) {
        return dishesDao.findAll(pageable);
    }

    @Override
    public Page<Dishes> getDishesListByCategoryId(int id, Pageable pageable) {
        return dishesDao.findByCategoryId(id,pageable);
    }
}
