package com.example.authcomplited.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fistName", length = 40)
    private String firstName;

    @Column(name = "lastName", length = 40)
    private String lastName;

    @Column(name = "email", length = 40)
    private String email;

    @Column(name = "password", length = 40)
    private String passwrd;
}
