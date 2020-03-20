package com.smartosc.training.webservice.facade;

import com.smartosc.training.dto.RoleDTO;
import com.smartosc.training.webservice.service.GeneralService;

import java.util.List;

public interface RoleFacade extends GeneralService<RoleDTO> {

    List<RoleDTO> findByEmail(String email);

}
