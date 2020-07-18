package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.H2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityExistsException;
import javax.security.auth.login.LoginException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class H2ServiceImpl implements H2Service {

    private final H2Repository h2Repository;

    @Autowired
    public H2ServiceImpl(H2Repository h2Repository) {
        this.h2Repository = h2Repository;
    }

    @PostConstruct
    private void setUp() {
        h2Repository.save(new User("user name", "password", "sample_email@email.com"));
        h2Repository.save(new User("2nd user name", "2nd password", "2nd_sample_email@email.com"));
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return (List<User>) h2Repository.findAll();
    }

    @Transactional
    public Optional<User> findById(Integer theId) {
        return h2Repository.findById(theId);
    }

    @Override
    @Transactional
    public void save(User theEntity) throws EntityExistsException {
        List<User> currentUserList = this.findAll();
        long isExists = currentUserList.stream().filter(ele -> ele.getEmail().equals(theEntity.getEmail())).count();
        if (isExists == 0)
            h2Repository.save(theEntity);
        else
            throw new EntityExistsException(theEntity.getEmail() + " Already Exists");
    }

    @Override
    @Transactional
    public void deleteById(Integer theId) {
        h2Repository.deleteById(theId);
    }

    @Override
    @Transactional
    public void login(User theEntity) throws LoginException {
        List<User> currentUserList = this.findAll();
        Stream<User> filteredUser = currentUserList.stream().filter(ele -> ele.getEmail().equals(theEntity.getEmail()));
        long isExists = filteredUser.count();
        if (isExists == 0)
            throw new LoginException("User does not exists");
        if (!filteredUser.collect(Collectors.toList()).get(0).getPassword().equals(theEntity.getPassword()))
            throw new LoginException("Incorrect password");
    }
}
