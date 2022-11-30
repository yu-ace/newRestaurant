package com.example.restaurant1.service.impl;

import com.example.restaurant1.dao.ITableDao;
import com.example.restaurant1.model.Table;
import com.example.restaurant1.service.ITableServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableService implements ITableServcie {

    @Autowired
    ITableDao tableDao;

    @Override
    public void newTable(String name) {
        Table table = new Table();
        table.setName(name);
        tableDao.save(table);
    }
}
