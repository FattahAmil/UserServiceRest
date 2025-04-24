package com.example.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public List<User> getAllUsers() {
        return List.of(
            new User(1, "Alice"),
            new User(2, "Bob")
        );
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return new User(id, "User" + id);
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        return "User " + user.name() + " created!";
    }
}
