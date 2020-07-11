package com.example.demo.repository;

import com.example.demo.model.H2Entity;
import org.springframework.data.repository.CrudRepository;

public interface H2Repository extends CrudRepository<H2Entity, Long> {
}
