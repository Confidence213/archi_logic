package com.polytech.eventmanager.controller;

import com.polytech.eventmanager.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<User> getUsers(@RequestParam(value = "id", defaultValue = "") Long id) {
        return new ArrayList<>();
    }

    // todo: add other methods

}
