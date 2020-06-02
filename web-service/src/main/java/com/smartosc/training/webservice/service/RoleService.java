package com.smartosc.training.webservice.service;

import com.smartosc.training.webservice.entity.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    Set<Role> findByUsersEmail(String email);

}
