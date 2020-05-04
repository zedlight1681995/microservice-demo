package com.smartosc.training.webservice.service;

import com.smartosc.training.webservice.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> findByUsersEmail(String email);

}
