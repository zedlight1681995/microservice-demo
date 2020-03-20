package com.smartosc.training.webservice.service.impl;

import com.smartosc.training.exception.EntityNotFoundException;
import com.smartosc.training.webservice.entity.Product;
import com.smartosc.training.webservice.entity.Role;
import com.smartosc.training.webservice.repository.RoleRepository;
import com.smartosc.training.webservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final MessageSource messages;

    @Autowired
    public RoleServiceImpl(final RoleRepository roleRepository,
                           @Qualifier("bundleMessageSource") final MessageSource messages) {
        this.roleRepository = roleRepository;
        this.messages = messages;
    }

    @Override
    public List<Role> findByEmail(String email) {
        return findByEmail(email);
    }

    @Override
    public List findByStatus(Integer status) {
        return null;
    }

    @Override
    public Product findById(Long id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public Object save(Object object) {
        return null;
    }

    @Override
    public Object update(Object object, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
