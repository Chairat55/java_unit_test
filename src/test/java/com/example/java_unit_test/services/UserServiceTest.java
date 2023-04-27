package com.example.java_unit_test.services;

import com.example.java_unit_test.dtos.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    public UserService userService;

    @Test
    void test_get_all() {
        // given
        List<User> result1 = new ArrayList<>();
        result1.add(new User(1, "A1"));
        result1.add(new User(2, "A2"));
        result1.add(new User(3, "A3"));

        // when
        List<User> result2 = userService.getAll();

        // then
        assertEquals(result1.size(), result2.size());
        assertEquals(result1.get(0).getId(), result2.get(0).getId());

//        assertAll("test_get_all",
//                () -> assertEquals(result1.size(), result2.size()),
//                () -> assertEquals(result1.get(0).getId(), result2.get(0).getId())
//        );
    }

}
