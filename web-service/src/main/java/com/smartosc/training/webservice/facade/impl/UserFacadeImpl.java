package com.smartosc.training.webservice.facade.impl;

import com.smartosc.training.dto.UserDTO;
import com.smartosc.training.exception.EntityNotFoundException;
import com.smartosc.training.webservice.entity.Product;
import com.smartosc.training.webservice.entity.User;
import com.smartosc.training.webservice.facade.UserFacade;
import com.smartosc.training.webservice.facade.mapper.UserMapper;
import com.smartosc.training.webservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;

    @Autowired
    public UserFacadeImpl(final UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDTO findByEmail(String email) {
        User user = userService.findByEmail(email);
        return user != null ? UserMapper.INSTANCE.userToUserDTO(user) : null;
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
