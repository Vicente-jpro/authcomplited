package com.example.authcomplited.services;

import org.springframework.stereotype.Service;

import com.example.authcomplited.exceptions.UserExistException;
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

        User userSalvo = getUserByEmail(user.getEmail());
        if (userSalvo != null) {
            log.info("Este email já foi usado: " + user.getEmail());
            throw new UserExistException("Este email já foi usado: " + user.getEmail());
        }

        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        log.info("Buscando usuario pelo email...");
        return userRepository.findByEmail(email);
    }
}
