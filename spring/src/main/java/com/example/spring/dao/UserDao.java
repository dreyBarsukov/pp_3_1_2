package com.example.spring.dao;


import com.example.spring.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    List<User> findAll();

    Optional<User> findOne(long id);

    void save(User user);

    void update(long id, User updeteUser);

    void delete(long id);
}
