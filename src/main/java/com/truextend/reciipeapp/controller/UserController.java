package com.truextend.reciipeapp.controller;

import com.truextend.reciipeapp.services.UserService;
import com.truextend.reciipeapp.api.v1.dto.UserDTO;
import com.truextend.reciipeapp.api.v1.mapper.UserMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return null;
    }

}
