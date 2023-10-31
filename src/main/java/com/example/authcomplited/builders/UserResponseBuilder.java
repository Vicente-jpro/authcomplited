package com.example.authcomplited.builders;

import org.springframework.stereotype.Component;

import com.example.authcomplited.models.User;
import com.example.authcomplited.request.UserRequest;
import com.example.authcomplited.responses.UserResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserResponseBuilder {

    public User toModel(UserRequest userModelRequest) {
        return User
                .builder()
                .firstName(userModelRequest.getFirstName())
                .lastName(userModelRequest.getLastName())
                .email(userModelRequest.getEmail())
                .passwrd(userModelRequest.getPasswrd())
                .build();

    }

    public UserResponse toDto(User user) {
        return UserResponse
                .builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();

    }
}
