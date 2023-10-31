package com.example.authcomplited.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private Long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String passwrd;
    private String encryptedPassword;
    private String emailVerificationToken;
    private Boolean emailVerificationStatus;
}
