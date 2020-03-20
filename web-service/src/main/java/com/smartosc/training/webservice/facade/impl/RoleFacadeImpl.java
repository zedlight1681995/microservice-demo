package com.smartosc.training.webservice.facade.impl;

import com.smartosc.training.dto.RoleDTO;
import com.smartosc.training.exception.EntityNotFoundException;
import com.smartosc.training.webservice.entity.Product;
import com.smartosc.training.webservice.entity.Role;
import com.smartosc.training.webservice.facade.RoleFacade;
import com.smartosc.training.webservice.facade.mapper.RoleMapper;
import com.smartosc.training.webservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleFacadeImpl implements RoleFacade {

    private final RoleService roleService;

    @Autowired
    public RoleFacadeImpl(final RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public List<RoleDTO> findByEmail(String email) {
        List<Role> roles = roleService.findByEmail(email);
        return roles.stream()
                .map(RoleMapper.INSTANCE::roleToRoleDTO)
                .collect(Collectors.toList());
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
