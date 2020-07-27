package com.example.demo.repository;

import com.example.demo.model.gym.GymClass;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoDBGymClassRepository extends MongoRepository<GymClass, String> {
}