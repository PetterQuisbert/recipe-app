package com.truextend.reciipeapp.services;

import com.truextend.reciipeapp.domain.security.User;
import com.truextend.reciipeapp.domain.security.UserRole;

import java.util.Set;

public interface UserService {
    User createUser(User user, Set<UserRole> userRoles);
    User findByUsername(String username);
    User findByEmail(String email);
    User save(User user);
    User findById(Long id);
}
