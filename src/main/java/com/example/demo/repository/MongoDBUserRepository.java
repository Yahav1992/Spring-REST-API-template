package com.example.demo.repository;

import com.example.demo.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoDBUserRepository extends MongoRepository<User, String> { }