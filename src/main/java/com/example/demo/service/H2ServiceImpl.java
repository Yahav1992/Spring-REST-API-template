package com.example.demo.service;

import com.example.demo.model.H2Entity;
import com.example.demo.repository.H2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class H2ServiceImpl implements H2Service {

    private final H2Repository h2Repository;

    @Autowired
    public H2ServiceImpl(H2Repository h2Repository) {
        this.h2Repository = h2Repository;
    }

    @PostConstruct
    private void setUp() {
        h2Repository.save(new H2Entity("sample first name", "sample last name", "sample_email@email.com"));
        h2Repository.save(new H2Entity("2nd sample first name", "2nd sample last name", "2nd_sample_email@email.com"));
    }

    @Override
    @Transactional
    public List<H2Entity> findAll() {
        return (List<H2Entity>) h2Repository.findAll();
    }

    @Transactional
    public Optional<H2Entity> findById(Integer theId) {
        return h2Repository.findById(theId);
    }

    @Override
    @Transactional
    public void save(H2Entity theEntity) {
        h2Repository.save(theEntity);
    }

    @Override
    @Transactional
    public void deleteById(Integer theId) {
        h2Repository.deleteById(theId);
    }
}
