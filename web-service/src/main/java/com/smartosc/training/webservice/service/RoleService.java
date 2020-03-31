package com.smartosc.training.webservice.service;

import com.smartosc.training.webservice.entity.Role;

import java.util.List;

public interface RoleService extends GeneralService {

    List<Role> findByUsers_Email(String email);

}
