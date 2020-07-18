package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.H2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;
import java.util.List;
import java.util.Optional;

@RestController
public class HomeController {

    @Value("${prop1.firstname}")
    private String firstName;
    @Value("${prop1.lastname}")
    private String lastName;

    private final H2Service h2Service;

    @Autowired
    public HomeController(H2Service h2Service) {
        this.h2Service = h2Service;
    }

    @GetMapping("/sampleString")
    public String sampleString() {
        return "test-main-menu";
    }

    @GetMapping("/appProp")
    public String applicationPropertiesData() {
        return firstName + " " + lastName;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return h2Service.findAll();
    }

    @GetMapping("/users/{userId}")
    public Optional<User> getUser(@PathVariable Integer userId) {
        return h2Service.findById(userId);
    }

    @PostMapping("/users")
    public ResponseEntity<?> saveUser(@RequestBody User newUser) {
        h2Service.save(newUser);
        return ResponseEntity.ok(newUser);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        h2Service.deleteById(userId);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User newUser) throws LoginException {
        h2Service.login(newUser);
        return ResponseEntity.ok(newUser);
    }
}
