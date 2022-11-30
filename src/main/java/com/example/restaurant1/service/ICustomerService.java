package com.example.restaurant1.service;

import com.example.restaurant1.model.Customer;

public interface ICustomerService {
    Customer newCustomer(int count, int tableId);
    Customer getCustomer(int tableId);
}
