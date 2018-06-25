package com.truextend.reciipeapp.controller;

import com.truextend.reciipeapp.api.v1.dto.UserDTO;
import com.truextend.reciipeapp.api.v1.dto.UserListDTO;
import com.truextend.reciipeapp.api.v1.mapper.UserMapper;
import com.truextend.reciipeapp.config.SecurityUtility;
import com.truextend.reciipeapp.domain.Role;
import com.truextend.reciipeapp.domain.User;
import com.truextend.reciipeapp.domain.UserRole;
import com.truextend.reciipeapp.services.RoleService;
import com.truextend.reciipeapp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/api/v1/users";

    private final UserService userService;
    private final RoleService roleService;
    private final UserMapper userMapper;

    public UserController(UserService userService, RoleService roleService, UserMapper userMapper) {
        this.userService = userService;
        this.roleService = roleService;
        this.userMapper = userMapper;
    }

    @PostMapping("/newUser")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
//        if(userService.findByUsername(userDTO.getUsername())  != null) {
//            return new ResponseEntity("usernameExist", HttpStatus.BAD_REQUEST);
//        }
//        if(userService.findByEmail(userDTO.getEmail())  != null) {
//            return new ResponseEntity("usernameExist", HttpStatus.BAD_REQUEST);
//        }

        System.out.println("userDTO = " + userDTO);
        User newUser = userMapper.userDTOToUser(userDTO);

        System.out.println("newUser = " + newUser);

        String password = SecurityUtility.randomPassword();
        String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
        newUser.setPassword(encryptedPassword);

        Role role_user = roleService.findByName("ROLE_USER");

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(newUser, role_user));

        System.out.println("newUser2 = " + newUser);

        userService.createUser(newUser, userRoles);

        return userMapper.userToUserDTO(newUser);

        // TODO: Send a mail with the password
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public UserListDTO list() {
        return new UserListDTO(userService.list());
    }

}

