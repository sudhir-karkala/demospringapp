package com.springboot.demo.services;

import com.springboot.demo.models.User;
import com.springboot.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefaultUserService implements UserService {
    UserRepository userRepository;

    @Autowired
    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User createUser(User requestUser) {
        User user = new User(requestUser.getName(),
                requestUser.getId(),
                requestUser.getGender());
        if (user.getId() == null) {
            user.setId(UUID.randomUUID());
        }
        user.setName(user.getName().toLowerCase());

        userRepository.addUser(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUser(UUID uuid) {
        return userRepository.getUser(uuid);
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.getUserByName(name);
    }
}
