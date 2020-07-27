package com.example.demo.service;

import com.example.demo.model.gym.GymClass;
import com.example.demo.model.user.AuthenticatedUser;
import com.example.demo.model.user.ClientUser;
import com.example.demo.model.user.User;
import com.example.demo.repository.MongoDBGymClassRepository;
import com.example.demo.repository.MongoDBUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityExistsException;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Primary
@Service("mongoS")
@EnableJpaRepositories({"com.example.demo.repository.MongoDBUserRepository", "com.example.demo.repository.MongoDBUserRepository"})
public class MongoServiceImpl implements BaseService {

    private final MongoDBUserRepository mongoDBUserRepository;
    private final MongoDBGymClassRepository mongoDBGymClassRepository;

    @Autowired
    public MongoServiceImpl(MongoDBUserRepository mongoDBUserRepository, MongoDBGymClassRepository mongoDBGymClassRepository) {
        this.mongoDBUserRepository = mongoDBUserRepository;
        this.mongoDBGymClassRepository = mongoDBGymClassRepository;
    }

    @PostConstruct
    private void setUp() {
        mongoDBUserRepository.save(new AuthenticatedUser(new User("test", "123", "test@gmail.com")));
        mongoDBGymClassRepository.save(new GymClass("Boxing", "Boxing sparring session with Tyson Fury", 499.99, Duration.ofHours(1), 1, "Tyson Fury"));
    }

    @PreDestroy
    private void finishUp() {
        mongoDBUserRepository.deleteAll();
        mongoDBGymClassRepository.deleteAll();
    }


    @Override
    public List<User> findAll() {
        return mongoDBUserRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer theId) {
        return mongoDBUserRepository.findById(theId.toString());
    }

    @Override
    public ClientUser authSave(User theEntity, HttpServletRequest req) throws RuntimeException {
        List<User> currentUserList = this.findAll();
        long isExists = currentUserList.stream().filter(ele -> ele.getUserName().equals(theEntity.getUserName())).count();
        if (isExists == 0) {
            // TODO: change to OAuth2 authentication
            AuthenticatedUser authenticatedEntity = new AuthenticatedUser(theEntity);
            AuthenticatedUser savedUser = mongoDBUserRepository.save(authenticatedEntity);
            return new ClientUser(savedUser);
        } else
            throw new EntityExistsException(theEntity.getUserName() + " Already Exists");
    }

    @Override
    public void login(User theEntity) throws LoginException {
        List<User> currentUserList = this.findAll();
        List<User> filteredUser = currentUserList.stream().filter(ele -> ele.getUserName().equals(theEntity.getUserName())).collect(Collectors.toList());

        if (filteredUser.size() == 0)
            throw new LoginException("User does not exists");

        if (!filteredUser.get(0).getPassword().equals(theEntity.getPassword()))
            throw new LoginException("Incorrect password");
    }

    @Override
    public void deleteById(Integer theId) {
        mongoDBUserRepository.deleteById(theId.toString());
    }
}

