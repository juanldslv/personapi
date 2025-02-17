package com.personapi.personapi.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personapi.personapi.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
