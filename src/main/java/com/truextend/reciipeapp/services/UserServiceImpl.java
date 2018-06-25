package com.truextend.reciipeapp.services;

import com.truextend.reciipeapp.domain.User;
import com.truextend.reciipeapp.domain.UserRole;
import com.truextend.reciipeapp.repository.RoleRepository;
import com.truextend.reciipeapp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public User createUser(User user, Set<UserRole> userRoles) {
        User localUser = userRepository.findByUsername(user.getUsername());

        if (localUser != null) {
            LOG.info("User with username {} already exist. Nothing will be done.", user.getUsername());
        } else {
            userRoles.forEach( ur -> roleRepository.save(ur.getRole()));

            user.getUserRoles().addAll(userRoles);

            System.out.println("user = " + user);

            localUser = userRepository.save(user);
        }

        return localUser;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User findById(Long id) {
        Optional<User> userOpt = userRepository.findById(id);
        return userOpt.orElse(null);
    }
}
