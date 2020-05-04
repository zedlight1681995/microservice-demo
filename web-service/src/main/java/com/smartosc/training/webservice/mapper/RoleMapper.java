package com.smartosc.training.webservice.mapper;

import com.smartosc.training.model.RoleDTO;
import com.smartosc.training.webservice.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDTO roleToRoleDTO(Role role);

}
