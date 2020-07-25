package com.example.demo.controller;

import com.example.demo.constants.constants;
import com.example.demo.model.User;
import com.example.demo.repository.H2Repository;
import com.example.demo.service.BaseService;
import com.example.demo.service.H2ServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

class HomeControllerTest {

    private static HomeController homeController;
    private static BaseService baseService;
    @Mock // testing using mock mvc on the repository.
    private static H2Repository h2Repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        baseService = new H2ServiceImpl(h2Repository);
        homeController = new HomeController(baseService);

        constants.MOCK_MVC_SAMPLE_RESPONSE.add(constants.MOCK_MVC_APPLICATION_PROPERTIES_DATA);
        doReturn(constants.MOCK_MVC_SAMPLE_RESPONSE).when(h2Repository).findAll();

    }

    @Test
    void sampleString() {
        assertEquals(constants.MOCK_MVC_SAMPLE_STRING, homeController.sampleString());
    }

    @Test
    void getAllH2Entities() {
        Iterable<User> result = h2Repository.findAll();
        assertEquals(result, constants.MOCK_MVC_SAMPLE_RESPONSE);
        verify(h2Repository, times(1)).findAll();
    }
}