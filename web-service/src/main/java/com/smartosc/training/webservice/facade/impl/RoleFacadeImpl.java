package com.smartosc.training.webservice.facade.impl;

import com.smartosc.training.dto.RoleDTO;
import com.smartosc.training.exception.EntityNotFoundException;
import com.smartosc.training.webservice.entity.Product;
import com.smartosc.training.webservice.facade.mapper.RoleFacade;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleFacadeImpl implements RoleFacade {

    @Override
    public List<RoleDTO> findByUsername(String username) {
        return null;
    }

    @Override
    public List<RoleDTO> findByStatus(Integer status) {
        return null;
    }

    @Override
    public Product findById(Long id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public RoleDTO save(RoleDTO object) {
        return null;
    }

    @Override
    public RoleDTO update(RoleDTO object, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
