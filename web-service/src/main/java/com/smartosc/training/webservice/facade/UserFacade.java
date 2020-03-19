package com.smartosc.training.webservice.facade;

import com.smartosc.training.dto.UserDTO;
import com.smartosc.training.webservice.service.GeneralService;

public interface UserFacade extends GeneralService<UserDTO> {

    UserDTO findByUsername(String username);

}
