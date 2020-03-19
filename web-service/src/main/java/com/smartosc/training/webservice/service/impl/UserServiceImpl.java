package com.smartosc.training.webservice.service.impl;

import com.smartosc.training.exception.EntityNotFoundException;
import com.smartosc.training.webservice.entity.Product;
import com.smartosc.training.webservice.entity.User;
import com.smartosc.training.webservice.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public List<User> findByStatus(Integer status) {
        return null;
    }

    @Override
    public Product findById(Long id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public User save(User object) {
        return null;
    }

    @Override
    public User update(User object, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
