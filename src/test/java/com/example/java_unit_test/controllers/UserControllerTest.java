package com.example.java_unit_test.controllers;

import com.example.java_unit_test.dtos.User;
import com.example.java_unit_test.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    UserService userService;

    @InjectMocks
    public UserController userController;

    @Test
    void test_success_get_all() {
        // given
        when(userService.getAll()).thenReturn(List.of(new User()));

        // when
        ResponseEntity<List<User>> result = userController.getAll();

        // then
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        verify(userService, times(1)).saveLog();
    }

    @Test
    void test_fail_get_all() {
        // given
        when(userService.getAll()).thenThrow(MockitoException.class);

        // when
        ResponseEntity<List<User>> result = userController.getAll();

        // then
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertNull(result.getBody());
        verify(userService, times(1)).saveLog();
    }

}
