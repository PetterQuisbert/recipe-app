package com.truextend.reciipeapp.api.v1.mapper;

import com.truextend.reciipeapp.domain.User;
import com.truextend.reciipeapp.api.v1.dto.UserDTO;

public interface UserMapper {
    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDTO);
}
