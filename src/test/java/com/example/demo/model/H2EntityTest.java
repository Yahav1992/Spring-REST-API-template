package com.example.demo.model;

import com.example.demo.constants.constants;
import org.junit.jupiter.api.*;

import static junit.framework.TestCase.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class H2EntityTest {

    private H2Entity entity;

    @BeforeEach
    public void setUp() {
        entity = new H2Entity(constants.initialFirstName, constants.initialLastName, constants.initialEmail);
    }

    @Test
    @Order(1)
    void getFirst() {
        assertEquals(constants.initialFirstName, entity.getFirst());
    }

    @Test
    @Order(2)
    void getLast() {
        assertEquals(constants.initialLastName, entity.getLast());
    }

    @Test
    @Order(3)
    void getEmail() {
        assertEquals(constants.initialEmail, entity.getEmail());
    }

    @Test
    @Order(4)
    public void setFirst() {
        entity.setFirst(constants.unitTestsFirstName);
        assertEquals(constants.unitTestsFirstName, entity.getFirst());
    }

    @Test
    @Order(5)
    void setLast() {
        entity.setLast(constants.unitTestsLastName);
        assertEquals(constants.unitTestsLastName, entity.getLast());
    }

    @Test
    @Order(6)
    void setEmail() {
        entity.setEmail(constants.unitTestsEmail);
        assertEquals(constants.unitTestsEmail, entity.getEmail());
    }
}