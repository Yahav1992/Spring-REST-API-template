package com.example.demo.controller;

import com.example.demo.constants.constants;
import com.example.demo.model.H2Entity;
import com.example.demo.repository.H2Repository;
import com.example.demo.service.H2Service;
import com.example.demo.service.H2ServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

class HomeControllerTest {

    private static HomeController homeController;
    private static H2Service h2Service;
    @Mock // testing using mock mvc on the repository.
    private static H2Repository h2Repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        h2Service = new H2ServiceImpl(h2Repository);
        homeController = new HomeController(h2Service);

        constants.mockMvcSampleResponse.add(constants.mockMvcApplicationPropertiesData);
        doReturn(constants.mockMvcSampleResponse).when(h2Repository).findAll();

    }

    @Test
    void sampleString() {
        assertEquals(constants.mockMvcSampleString, homeController.sampleString());
    }

    @Test
    void getAllH2Entities() {
        Iterable<H2Entity> result = h2Repository.findAll();
        assertEquals(result, constants.mockMvcSampleResponse);
        verify(h2Repository, times(1)).findAll();
    }
}