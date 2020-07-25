package com.example.demo.controller;

import com.example.demo.constants.constants;
import com.example.demo.model.User;
import com.example.demo.repository.MongoDBRepository;
import com.example.demo.service.BaseService;
import com.example.demo.service.MongoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

class HomeControllerTest {

    private static HomeController homeController;
    @Mock // testing using mock mvc on the repository.
    private static MongoDBRepository mongoRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        BaseService baseService = new MongoServiceImpl(mongoRepo);
        homeController = new HomeController(baseService);

        constants.MOCK_MVC_SAMPLE_RESPONSE.add(constants.MOCK_MVC_APPLICATION_PROPERTIES_DATA);
        doReturn(constants.MOCK_MVC_SAMPLE_RESPONSE).when(mongoRepo).findAll();

    }

    @Test
    void sampleString() {
        assertEquals(constants.MOCK_MVC_SAMPLE_STRING, homeController.sampleString());
    }

    @Test
    void getAllH2Entities() {
        Iterable<User> result = mongoRepo.findAll();
        assertEquals(result, constants.MOCK_MVC_SAMPLE_RESPONSE);
        verify(mongoRepo, times(1)).findAll();
    }
}