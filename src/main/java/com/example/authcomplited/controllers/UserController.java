package com.example.authcomplited.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.authcomplited.builders.UserRequestBuilder;
import com.example.authcomplited.builders.UserResponseBuilder;
import com.example.authcomplited.models.User;
import com.example.authcomplited.request.UserRequest;
import com.example.authcomplited.responses.UserResponse;
import com.example.authcomplited.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRequestBuilder userRequestBuilder;
    private final UserResponseBuilder userResponseBuilder;

    @GetMapping
    public String getUser() {
        return "Hello form user controller.";
    }

    @PatchMapping
    public String updateUser() {
        return "Hello form user controller.";
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userModelRequest) {
        User user = userRequestBuilder.toModel(userModelRequest);
        User userSalvo = userService.salvar(user);
        UserResponse userResponse = userResponseBuilder.toDto(userSalvo);
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping
    public String deleteUser() {
        return "Hello form user controller.";
    }
}
