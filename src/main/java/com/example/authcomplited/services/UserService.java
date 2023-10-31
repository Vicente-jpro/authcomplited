package com.example.authcomplited.services;

import org.springframework.stereotype.Service;

import com.example.authcomplited.models.User;
import com.example.authcomplited.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User salvar(User user) {
        log.info("Salvando usuario...");
        return userRepository.save(user);
    }
}
