package com.example.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByUserName(String userName);
}
