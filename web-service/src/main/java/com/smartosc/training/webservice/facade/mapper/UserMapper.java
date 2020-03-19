package com.smartosc.training.webservice.facade.mapper;

import com.smartosc.training.dto.UserDTO;
import com.smartosc.training.webservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDTO);

}
