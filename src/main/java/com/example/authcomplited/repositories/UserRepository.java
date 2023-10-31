package com.example.authcomplited.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.authcomplited.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
