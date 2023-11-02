package com.example.authcomplited.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.authcomplited.dto.UserDto;
import com.example.authcomplited.exceptions.UserExistException;
import com.example.authcomplited.models.User;
import com.example.authcomplited.repositories.UserRepository;
import com.example.authcomplited.utils.MD5hash;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MD5hash md5hash;

    public User salvar(UserDto userDto) {
        log.info("Salvando usuario...");

        User userSalvo = getUserByEmail(userDto.getEmail());
        if (userSalvo != null) {
            log.info("Este email já foi usado: " + userDto.getEmail());
            throw new UserExistException("Este email já foi usado: " + userDto.getEmail());
        }

        String passwordCriptografada = passwordEncoder.encode(userDto.getEmail());
        userDto.setEncryptedPassword(passwordCriptografada);
        userDto.setUserId(md5hash.getShash());

        User user = new User();
        BeanUtils.copyProperties(userDto, user);

        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        log.info("Buscando usuario pelo email...");
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }
}
