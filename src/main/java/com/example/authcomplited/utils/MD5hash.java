package com.example.authcomplited.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class MD5hash {

    private String firstName;
    private String lastName;
    private String email;

    public MD5hash(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getShash() {
        String hash = firstName + email + lastName;
        return DigestUtils.md5DigestAsHex(hash.getBytes());
    }
}
