package com.truextend.reciipeapp.repositories;

import com.truextend.reciipeapp.domain.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
