package com.springboot.demo.services;

import com.springboot.demo.models.User;
import java.util.List;
import java.util.UUID;

public interface UserService {
    public User createUser(User user);
    public List<User> getAllUsers();
    public User getUser(UUID uuid);
    public User getUserByName(String name);
}
