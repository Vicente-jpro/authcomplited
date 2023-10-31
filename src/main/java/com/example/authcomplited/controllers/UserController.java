package com.example.authcomplited.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {

    @GetMapping
    public String getUser() {
        return "Hello form user controller.";
    }

    @PatchMapping
    public String updateUser() {
        return "Hello form user controller.";
    }

    @PostMapping
    public String create() {
        return "Hello form user controller.";
    }

    @DeleteMapping
    public String deleteUser() {
        return "Hello form user controller.";
    }
}
