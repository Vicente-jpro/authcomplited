package com.example.authcomplited.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.authcomplited.exceptions.UserExistException;
import com.example.authcomplited.models.User;
import com.example.authcomplited.repositories.UserRepository;
import com.example.authcomplited.utils.MD5hash;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    private MD5hash md5hash;

    public User salvar(User user) {
        log.info("Salvando usuario...");

        User userSalvo = getUserByEmail(user.getEmail());
        if (userSalvo != null) {
            log.info("Este email já foi usado: " + user.getEmail());
            throw new UserExistException("Este email já foi usado: " + user.getEmail());
        }
        user.setUserId(md5hash.getShash());
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        log.info("Buscando usuario pelo email...");
        return userRepository.findByEmail(email);
    }
}
