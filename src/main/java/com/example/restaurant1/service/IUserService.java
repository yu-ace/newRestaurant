package com.example.restaurant1.service;

import com.example.restaurant1.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    User getUserByName(String name);
    User getUserById(int id);
    void newUser(String name,String password,String identity,double wage);
    void deleteUser(int id);
    void changeUserIsDelete(String name);
    void changePassword(String name,String password);
    Page<User> getUserList(int delete, Pageable pageable);
    Page<User> getUserByIdentity(String identity, Pageable pageable);
    Page<User> getUserByWageGreaterThanEqual(double wage, Pageable pageable);
}
