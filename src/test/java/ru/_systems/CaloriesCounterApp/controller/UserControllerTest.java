package ru._systems.CaloriesCounterApp.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru._systems.CaloriesCounterApp.interfaces.UserService;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static ru._systems.CaloriesCounterApp.constants.UserControllerConstants.*;
import static ru._systems.CaloriesCounterApp.constants.UserEntityConstants.USERS_LIST;
import static ru._systems.CaloriesCounterApp.constants.UserEntityConstants.USER_ONE_MALE;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @Test
    @DisplayName("Should return user when post method is invoked")
    void shouldReturnUserWhenPostMethodIsInvoked() throws Exception{
        when(userService.createUser(USER_ONE_MALE)).thenReturn(USER_ONE_MALE);
        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(USER_ONE_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(USER_ONE_JSON));
    }

    @Test
    @DisplayName("Should return users list when get method is invoked without parameters")
    void shouldReturnUsersListWhenGetMethodIsInvokedWithoutParameters() throws Exception{
        when(userService.getUsersAll()).thenReturn(USERS_LIST);
        mockMvc.perform(get("/users")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(USERS_JSON));
    }

    @Test
    @DisplayName("Should return user when get method is invoked with parameters")
    void shouldReturnUserWhenGetMethodIsInvokedWithParameters() throws Exception{
        when(userService.getUserById(1L)).thenReturn(USER_ONE_MALE);
        mockMvc.perform(get("/users?userId=1")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(USER_ONE_JSON));
    }

    @Test
    @DisplayName("Should return user when put method is invoked")
    void shouldReturnUserWhenPutMethodIsInvoked() throws Exception{
        when(userService.updateUser(USER_ONE_MALE)).thenReturn(USER_ONE_MALE);
        mockMvc.perform(put("/users").contentType(MediaType.APPLICATION_JSON).content(USER_ONE_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(USER_ONE_JSON));
    }

    @Test
    @DisplayName("Should return status OK when delete method is invoked")
    void shouldReturnStatusOkWhenDeleteMethodIsInvoked() throws Exception{
        doNothing().when(userService).deleteUser(1L);
        mockMvc.perform(delete("/users/1")).andExpect(status().isOk());
    }
}

