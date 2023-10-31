package com.example.authcomplited.dto;

import javax.persistence.Column;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModelDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String passwrd;
}
