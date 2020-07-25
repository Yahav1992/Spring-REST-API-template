package com.example.demo.controller;

import com.example.demo.constants.constants;
import com.example.demo.service.BaseService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doReturn;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class HomeControllerIT {

    @Mock
    BaseService baseService;
    @InjectMocks
    HomeController homeController;

    MockMvc mockMvc;

    @Autowired
    public void setMockMvc(MockMvc mock){
        this.mockMvc = mock;
    }

//    @BeforeEach
//    void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
//    }


    @Test
    void getAllH2Entities() throws Exception {
        doReturn(constants.MOCK_MVC_H_2_ENTITIES_RESPONSE).when(baseService).findAll();
        mockMvc.perform(get("http://localhost:8080/api/users").with(user("user").password("password"))).andExpect(status().isOk());
    }

}