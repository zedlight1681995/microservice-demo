package com.smartosc.training.webservice.facade.mapper;

import com.smartosc.training.dto.RoleDTO;
import com.smartosc.training.webservice.service.GeneralService;

import java.util.List;

public interface RoleFacade extends GeneralService<RoleDTO> {

    List<RoleDTO> findByUsername(String username);

}
