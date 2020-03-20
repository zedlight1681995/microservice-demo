package com.smartosc.training.webservice.service;

import com.smartosc.training.webservice.entity.User;

public interface UserService extends GeneralService<User> {

    User findByEmail(String email);

}
