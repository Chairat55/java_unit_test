package com.example.java_unit_test.services;

import com.example.java_unit_test.dtos.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    final List<User> users = new ArrayList<>();

    UserService() {
        users.add(new User(1, "A1"));
        users.add(new User(2, "A2"));
        users.add(new User(3, "A3"));
    }

    public User getById(int id) {
        return users.stream().filter(user -> id == user.getId()).findFirst().orElse(null);
    }

    public List<User> getAll() {
        return users;
    }

    public void saveLog() {
    }


}
