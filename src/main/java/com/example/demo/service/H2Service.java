package com.example.demo.service;

import com.example.demo.model.H2Entity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface H2Service {

    public List<H2Entity> findAll();

    public Optional<H2Entity> findById(Long theId);

    public void save(H2Entity theEntity);

    public void deleteById(Long theId);
}
