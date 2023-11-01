package com.example.authcomplited.builders;

import org.springframework.stereotype.Component;

import com.example.authcomplited.dto.UserRequestDto;
import com.example.authcomplited.dto.UserResponseDto;
import com.example.authcomplited.models.User;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserResponseBuilder {

    public User toModel(UserRequestDto userModelRequest) {
        return User
                .builder()
                .firstName(userModelRequest.getFirstName())
                .lastName(userModelRequest.getLastName())
                .email(userModelRequest.getEmail())
                .passwrd(userModelRequest.getPasswrd())
                .build();

    }

    public UserResponseDto toDto(User user) {
        return UserResponseDto
                .builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();

    }
}
