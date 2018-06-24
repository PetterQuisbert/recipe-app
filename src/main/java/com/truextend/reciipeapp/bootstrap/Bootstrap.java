package com.truextend.reciipeapp.bootstrap;

import com.truextend.reciipeapp.config.SecurityUtility;
import com.truextend.reciipeapp.domain.security.Role;
import com.truextend.reciipeapp.domain.security.User;
import com.truextend.reciipeapp.domain.security.UserRole;
import com.truextend.reciipeapp.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Bootstrap implements CommandLineRunner {

    private final UserService userService;

    public Bootstrap(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setFirstname("Petter");
        user1.setLastname("Quisbert");
        user1.setEmail("petter.quisbert@gmail.com");
        user1.setUsername("p");
        user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));

        Role role1 = new Role();
        role1.setId(1L);
        role1.setName("ROLE_USER");

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(user1, role1));

        userService.createUser(user1, userRoles);
        userRoles.clear();

        User user2 = new User();
        user2.setFirstname("Admin");
        user2.setLastname("Admin");
        user2.setEmail("admin@gmail.com");
        user2.setUsername("a");
        user2.setPassword(SecurityUtility.passwordEncoder().encode("p"));

        Role role2 = new Role();
        role2.setId(1L);
        role2.setName("ROLE_ADMIN");

        userRoles.add(new UserRole(user2, role2));

        userService.createUser(user2, userRoles);
        userRoles.clear();

    }
}
