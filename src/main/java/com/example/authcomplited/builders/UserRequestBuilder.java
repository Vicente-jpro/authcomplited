package com.example.authcomplited.builders;

import org.springframework.stereotype.Component;

import com.example.authcomplited.models.User;
import com.example.authcomplited.request.UserRequest;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserRequestBuilder {

    public User toModel(UserRequest userModelRequest) {
        return User
                .builder()
                .firstName(userModelRequest.getFirstName())
                .lastName(userModelRequest.getLastName())
                .email(userModelRequest.getEmail())
                .passwrd(userModelRequest.getPasswrd())
                .build();

    }

    public UserRequest toDto(User user) {
        return UserRequest
                .builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .passwrd(user.getPasswrd())
                .build();

    }
}
