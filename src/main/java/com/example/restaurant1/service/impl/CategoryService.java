package com.example.restaurant1.service.impl;

import com.example.restaurant1.dao.ICategoryDao;
import com.example.restaurant1.model.Category;
import com.example.restaurant1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    ICategoryDao categoryDao;

    @Override
    public void newCategory(String name) {
        Category category = new Category();
        category.setName(name);
        categoryDao.save(category);
    }
}
