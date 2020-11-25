package com.springboot.demo.repositories;

import com.springboot.demo.models.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    Map<UUID, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void removeUser(UUID uuid) {
        users.remove(uuid);
    }

    public User getUser(UUID uuid) {
        return users.get(uuid);
    }

    public User getUserByName(String name) {
        name = name.toLowerCase();
        for (User u : users.values()) {
            if (u.getName().equals(name)) {
                return u;
            }
        }
        return null;
    }

    public User updateUser(User user) {
        User original = users.get(user.getId());
        original.setName(user.getName());
        original.setGender(user.getGender());
        return original;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
}
