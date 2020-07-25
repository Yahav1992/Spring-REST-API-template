package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.List;
import java.util.Optional;

@Service
public interface BaseService {
    List<User> findAll();

    Optional<User> findById(Integer theId);

    void save(User theEntity) throws RuntimeException;

    void login(User theEntity) throws LoginException;

    void deleteById(Integer theId);
}
