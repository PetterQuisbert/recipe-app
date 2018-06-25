package com.truextend.reciipeapp.api.v1.mapper;

import com.truextend.reciipeapp.domain.User;
import com.truextend.reciipeapp.api.v1.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    public UserDTO userToUserDTO(User user) {
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setUserRoles(user.getUserRoles());
        return userDTO;
    }

    public User userDTOToUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setPhone(userDTO.getPhone());
        user.setUserRoles(userDTO.getUserRoles());

        return user;
    }
}
