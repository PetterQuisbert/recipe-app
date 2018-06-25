package com.truextend.reciipeapp.services;

import com.truextend.reciipeapp.domain.Role;

public interface RoleService {
    Role findByName(String name);
}
