package com.example.restaurant1.service.impl;

import com.example.restaurant1.dao.ICustomerDao;
import com.example.restaurant1.model.Customer;
import com.example.restaurant1.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerDao customerDao;

    @Override
    public Customer newCustomer(int count, int tableId) {
        Customer customer = new Customer();
        customer.setCount(count);
        customer.setTableId(tableId);
        customerDao.save(customer);
        return customer;
    }

    @Override
    public Customer getCustomer(int tableId) {
        return customerDao.findByTableId(tableId);
    }
}
