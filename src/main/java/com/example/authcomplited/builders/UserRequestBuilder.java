package com.example.authcomplited.builders;

import org.springframework.stereotype.Component;

import com.example.authcomplited.dto.UserRequestDto;
import com.example.authcomplited.models.User;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserRequestBuilder {

    public User toModel(UserRequestDto userModelRequest) {
        return User
                .builder()
                .firstName(userModelRequest.getFirstName())
                .lastName(userModelRequest.getLastName())
                .email(userModelRequest.getEmail())
                .passwrd(userModelRequest.getPasswrd())
                .build();

    }

    public UserRequestDto toDto(User user) {
        return UserRequestDto
                .builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .passwrd(user.getPasswrd())
                .build();

    }
}
