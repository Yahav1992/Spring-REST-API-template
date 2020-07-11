package com.example.demo.controller;

import com.example.demo.model.H2Entity;
import com.example.demo.service.H2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/h2Entities")
    public List<H2Entity> getAllH2Entities() {
        return h2Service.findAll();
    }

    @GetMapping("/h2Entities/{entityId}")
    public Optional<H2Entity> getH2Entity(@PathVariable Integer entityId) {
        return h2Service.findById(entityId);
    }

    @PostMapping("/h2Entities")
    public H2Entity saveH2Entity(@RequestBody H2Entity newH2Entity) {
        h2Service.save(newH2Entity);
        return newH2Entity;
    }

    @DeleteMapping("/h2Entities/{entityId}")
    public void deleteH2Entity(@PathVariable Integer entityId) {
        h2Service.deleteById(entityId);
    }
}
