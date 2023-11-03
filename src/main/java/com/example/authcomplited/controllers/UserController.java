package com.example.authcomplited.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.authcomplited.dto.TokenDto;
import com.example.authcomplited.dto.UserDto;
import com.example.authcomplited.dto.UserLoginDto;
import com.example.authcomplited.dto.UserRequestDto;
import com.example.authcomplited.dto.UserResponseDto;
import com.example.authcomplited.exceptions.SenhaInvalidaException;
import com.example.authcomplited.models.User;
import com.example.authcomplited.securityjwt.JwtService;
import com.example.authcomplited.services.UserService;
import com.example.authcomplited.utils.MD5hash;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private MD5hash md5hash;

    @GetMapping
    public String getUser() {
        md5hash = new MD5hash("Vicente", "Simão", "vicenteviciii@gmail.com");
        return md5hash.getShash();
    }

    @PatchMapping
    public String updateUser() {
        return "Hello form user controller.";
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto userRequestDto) {

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequestDto, userDto);
        User userSalvo = userService.salvar(userDto);

        UserResponseDto userResponseDto = new UserResponseDto();
        BeanUtils.copyProperties(userSalvo, userResponseDto);

        return ResponseEntity.ok(userResponseDto);
    }

    @PostMapping("/login")
    public TokenDto autenticar(@RequestBody UserLoginDto userLoginDto) {

        try {
            User user = new User();
            BeanUtils.copyProperties(userLoginDto, user);

            UserDetails usuarioAutenticado = this.userService.autenticar(userLoginDto);

            String token = jwtService.gerarToken(user);

            return TokenDto
                    .builder()
                    .email(user.getEmail())
                    .token(token)
                    .build();

        } catch (SenhaInvalidaException | UsernameNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }

    }

    @DeleteMapping
    public String deleteUser() {
        return "Hello form user controller.";
    }
}
