package com.smartosc.training.webservice.mapper;

import com.smartosc.training.model.UserDTO;
import com.smartosc.training.webservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "roles", ignore = true)
    UserDTO userToUserDTO(User user);

}
