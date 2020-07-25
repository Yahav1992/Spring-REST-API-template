package com.example.demo.service;

import com.example.demo.model.AuthenticatedUser;
import com.example.demo.model.ClientUser;
import com.example.demo.model.User;
import com.example.demo.repository.MongoDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Primary
@Service("mongoS")
@EnableJpaRepositories("com.example.demo.repository.MongoDBRepository")
public class MongoServiceImpl implements BaseService {

    private final MongoDBRepository mongoDBRepository;

    @Autowired
    public MongoServiceImpl(MongoDBRepository mongoDBRepository) {
        this.mongoDBRepository = mongoDBRepository;
    }

    @Override
    public List<User> findAll() {
        return mongoDBRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer theId) {
        return mongoDBRepository.findById(theId.toString());
    }

    @Override
    public ClientUser authSave(User theEntity, HttpServletRequest req) throws RuntimeException {
        List<User> currentUserList = this.findAll();
        long isExists = currentUserList.stream().filter(ele -> ele.getUserName().equals(theEntity.getUserName())).count();
        if (isExists == 0) {
            // TODO: change to OAuth2 authentication
            AuthenticatedUser authenticatedEntity = new AuthenticatedUser(theEntity);
            AuthenticatedUser savedUser = mongoDBRepository.save(authenticatedEntity);
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
        mongoDBRepository.deleteById(theId.toString());
    }
}

