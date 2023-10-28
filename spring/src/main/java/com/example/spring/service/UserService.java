package com.example.spring.service;


import com.example.spring.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findOne(long id);

    void save(User user);

    void update(long id, User updeteUser);

    void delete(long id);
}
