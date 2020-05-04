package com.smartosc.training.webservice.service;

import com.smartosc.training.webservice.entity.User;

public interface UserService {

    User findByEmail(String email);

}
