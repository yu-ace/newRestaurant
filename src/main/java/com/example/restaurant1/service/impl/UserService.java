package com.example.restaurant1.service.impl;

import com.example.restaurant1.dao.IUserDao;
import com.example.restaurant1.model.User;
import com.example.restaurant1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserDao userDao;

    @Override
    public User getUserByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public User getUserById(int id) {
        return userDao.findById(id);
    }

    @Override
    public void newUser(String name, String password,String identity,double wage) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setIdentity(identity);
        user.setWage(wage);
        user.setIsDelete(0);
        userDao.save(user);
    }

    @Override
    public void deleteUser(int id) {
        User user = userDao.findById(id);
        user.setIsDelete(1);
        userDao.save(user);
    }

    @Override
    public void changeUserIsDelete(String name) {
        User user = userDao.findByName(name);
        user.setIsDelete(0);
        userDao.save(user);
    }

    @Override
    public void changePassword(String name, String password) {
        User user = userDao.findByName(name);
        user.setPassword(password);
        userDao.save(user);
    }

    @Override
    public Page<User> getUserList(int delete, Pageable pageable) {
        return userDao.findByIsDelete(delete,pageable);
    }

    @Override
    public Page<User> getUserByIdentity(String identity, Pageable pageable) {
        return userDao.findByIdentity(identity,pageable);
    }

    @Override
    public Page<User> getUserByWageGreaterThanEqual(double wage, Pageable pageable) {
        return userDao.findByWageGreaterThanEqual(wage,pageable);
    }
}
