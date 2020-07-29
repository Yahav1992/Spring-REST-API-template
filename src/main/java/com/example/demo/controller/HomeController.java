package com.example.demo.controller;

import com.example.demo.model.gym.GymClass;
import com.example.demo.model.user.User;
import com.example.demo.service.BaseService;
import com.example.demo.service.MongoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class HomeController {

    @Value("${prop1.firstname}")
    private String firstName;
    @Value("${prop1.lastname}")
    private String lastName;

    @Qualifier(value = "mongoS")
    private final BaseService baseService;

    @Autowired
    public HomeController(BaseService baseService) {
        this.baseService = baseService;
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
        return baseService.findAll();
    }

    @GetMapping("/users/{userId}")
    public Optional<User> getUser(@PathVariable Integer userId) {
        return baseService.findById(userId);
    }

    @PostMapping("/users")
    public ResponseEntity<?> saveUser(@RequestBody User newUser, HttpServletRequest req) {
        return ResponseEntity.ok(baseService.authSave(newUser, req));
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        baseService.deleteById(userId);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User newUser) throws LoginException {
        baseService.login(newUser);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/courses")
    public List<GymClass> getAllCourses() {
        return ((MongoServiceImpl) baseService).findAllCourses();
    }

}
