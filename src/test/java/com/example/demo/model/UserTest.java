package com.example.demo.model;

import com.example.demo.constants.constants;
import org.junit.jupiter.api.*;

import static junit.framework.TestCase.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserTest {

    private User entity;

    @BeforeEach
    public void setUp() {
        entity = new User(constants.INITIAL_NAME, constants.INITIAL_PASSWORD, constants.INITIAL_EMAIL);
    }

    @Test
    @Order(1)
    void getFirst() {
        assertEquals(constants.INITIAL_NAME, entity.getUserName());
    }

    @Test
    @Order(2)
    void getPassword() {
        assertEquals(constants.INITIAL_PASSWORD, entity.getPassword());
    }

    @Test
    @Order(3)
    void getEmail() {
        assertEquals(constants.INITIAL_EMAIL, entity.getEmail());
    }

    @Test
    @Order(4)
    public void setFirst() {
        entity.setUserName(constants.UNIT_TESTS_NAME);
        assertEquals(constants.UNIT_TESTS_NAME, entity.getUserName());
    }

    @Test
    @Order(5)
    void setPassword() {
        entity.setPassword(constants.UNIT_TESTS_PASSWORD);
        assertEquals(constants.UNIT_TESTS_PASSWORD, entity.getEmail());
    }

    @Test
    @Order(6)
    void setEmail() {
        entity.setEmail(constants.UNIT_TESTS_EMAIL);
        assertEquals(constants.UNIT_TESTS_EMAIL, entity.getEmail());
    }
}