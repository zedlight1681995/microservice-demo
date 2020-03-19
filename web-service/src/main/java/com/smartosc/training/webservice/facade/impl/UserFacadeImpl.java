package com.smartosc.training.webservice.facade.impl;

import com.smartosc.training.dto.UserDTO;
import com.smartosc.training.exception.EntityNotFoundException;
import com.smartosc.training.webservice.entity.Product;
import com.smartosc.training.webservice.facade.UserFacade;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserFacadeImpl implements UserFacade {

    @Override
    public UserDTO findByUsername(String username) {
        return null;
    }

    @Override
    public List<UserDTO> findByStatus(Integer status) {
        return null;
    }

    @Override
    public Product findById(Long id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public UserDTO save(UserDTO object) {
        return null;
    }

    @Override
    public UserDTO update(UserDTO object, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
