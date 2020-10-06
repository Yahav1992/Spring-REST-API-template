package com.example.demo.service;

import com.example.demo.model.user.ClientUser;
import com.example.demo.model.user.User;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public interface BaseService {
    List<User> findAll();

    Optional<User> findById(String theId);

    ClientUser authSave(User theEntity, HttpServletRequest req) throws RuntimeException;

    void login(User theEntity) throws LoginException;

    void deleteById(String theId);
}
