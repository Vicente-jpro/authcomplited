package com.example.authcomplited.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
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
import com.example.authcomplited.utils.MD5hash;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Autowired
    private MD5hash md5hash;

    @GetMapping
    public String getUser() {
        md5hash = new MD5hash("Vicente", "Simão", "vicenteviciii@gmail.com");
        return md5hash.getShash();
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
