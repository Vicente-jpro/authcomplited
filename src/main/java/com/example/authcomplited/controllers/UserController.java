package com.example.authcomplited.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.authcomplited.dto.UserRequestDto;
import com.example.authcomplited.dto.UserResponseDto;
import com.example.authcomplited.models.User;
import com.example.authcomplited.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String getUser() {
        return "Hello form user controller.";
    }

    @PatchMapping
    public String updateUser() {
        return "Hello form user controller.";
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto userRequestDto) {

        User user = new User();
        BeanUtils.copyProperties(userRequestDto, user);
        User userSalvo = userService.salvar(user);

        UserResponseDto userResponseDto = new UserResponseDto();
        BeanUtils.copyProperties(userSalvo, userResponseDto);

        return ResponseEntity.ok(userResponseDto);
    }

    @DeleteMapping
    public String deleteUser() {
        return "Hello form user controller.";
    }
}
