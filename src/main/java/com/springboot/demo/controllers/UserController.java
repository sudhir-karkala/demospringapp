package com.springboot.demo.controllers;

import com.springboot.demo.models.User;
import com.springboot.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping(value = "/create", method = {RequestMethod.POST, RequestMethod.PUT})
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("")
    public List<User> getAllUsers() {
        System.out.println();
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable(name="id") UUID uuid) {
        return userService.getUser(uuid);
    }
}
