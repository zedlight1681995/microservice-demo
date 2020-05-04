package com.smartosc.training.webservice.service.impl;

import com.smartosc.training.webservice.entity.Role;
import com.smartosc.training.webservice.repository.RoleRepository;
import com.smartosc.training.webservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(final RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findByUsersEmail(String email) {
        return roleRepository.findByUsersEmail(email);
    }

}
