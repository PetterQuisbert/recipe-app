package com.truextend.reciipeapp.api.v1.dto;

import java.util.List;

public class UserListDTO {

    List<UserDTO> userDTOS;

    public UserListDTO() {
    }

    public UserListDTO(List<UserDTO> userDTOS) {
        this.userDTOS = userDTOS;
    }

    public List<UserDTO> getUserDTOS() {
        return userDTOS;
    }

    public void setUserDTOS(List<UserDTO> userDTOS) {
        this.userDTOS = userDTOS;
    }
}
