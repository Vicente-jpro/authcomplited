package com.example.authcomplited.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "fistName", length = 40, nullable = false)
    private String firstName;

    @Column(name = "lastName", length = 40, nullable = false)
    private String lastName;

    @Column(name = "email", length = 40, nullable = false)
    private String email;

    @Column(name = "password", length = 40, nullable = false)
    private String passwrd;

    @Column(name = "encrypted_password")
    private String encryptedPassword;

    @Column(name = "email_verification_token")
    private String emailVerificationToken;

    @Column(name = "email_verification_status")
    private Boolean emailVerificationStatus;
}
