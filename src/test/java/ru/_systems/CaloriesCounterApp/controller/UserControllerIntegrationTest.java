package ru._systems.CaloriesCounterApp.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru._systems.CaloriesCounterApp.constants.UserControllerConstants.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should return empty users list when get method is invoked without parameters")
    @Order(1)
    void shouldReturnEmptyUsersListWhenGetMethodIsInvokedWithoutParameters() throws Exception{
        mockMvc.perform(get("/users")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("[]"));
    }

    @Test
    @DisplayName("Should return user when post method is invoked")
    @Order(2)
    void shouldReturnUserWhenPostMethodIsInvoked() throws Exception{
        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(USER_ONE_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(USER_ONE_JSON_SAVED));
    }

    @Test
    @DisplayName("Should return users list when get method is invoked without parameters")
    @Order(3)
    void shouldReturnUsersListWhenGetMethodIsInvokedWithoutParameters() throws Exception{
        mockMvc.perform(get("/users")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("[" + USER_ONE_JSON_SAVED + "]"));
    }

    @Test
    @DisplayName("Should return status Not found when get method is invoked with parameters")
    @Order(4)
    void shouldReturnStatusNotFoundWhenGetMethodIsInvokedWithParameters() throws Exception{
        mockMvc.perform(get("/users?userId=10")).andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Should return user when put method is invoked")
    void shouldReturnUserWhenPutMethodIsInvoked() throws Exception{
        mockMvc.perform(put("/users").contentType(MediaType.APPLICATION_JSON).content(USER_TWO_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(USER_TWO_JSON_SAVED));
    }

    @Test
    @DisplayName("Should return user when get method is invoked with parameters")
    @Order(5)
    void shouldReturnUserWhenGetMethodIsInvokedWithParameters() throws Exception {
        mockMvc.perform(get("/users?userId=1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(USER_ONE_JSON_SAVED));
    }

    @Test
    @DisplayName("Should return status OK when delete method is invoked")
    @Order(6)
    void shouldReturnStatusOkWhenDeleteMethodIsInvoked() throws Exception{
        mockMvc.perform(delete("/users/25")).andExpect(status().isOk());
    }
}
