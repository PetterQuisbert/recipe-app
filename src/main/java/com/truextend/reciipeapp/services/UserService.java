package com.truextend.reciipeapp.services;

import com.truextend.reciipeapp.api.v1.dto.UserDTO;
import com.truextend.reciipeapp.domain.User;
import com.truextend.reciipeapp.domain.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {
    User createUser(User user, Set<UserRole> userRoles);
    User findByUsername(String username);
    User findByEmail(String email);
    User save(User user);
    User findById(Long id);
    List<UserDTO> list();
}
