package com.example.spring.dao;

import com.example.spring.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    EntityManager entityManager;

    public UserDaoImpl() {
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }

    @Override
    public Optional<User> findOne(long id) {
        return Optional.of(Optional.ofNullable(entityManager.find(User.class, id)).orElseThrow());
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(long id, User updeteUser) {
        entityManager.merge(updeteUser);
    }

    @Override
    public void delete(long id) {
        try {
            entityManager.remove(findOne(id).get());
        } catch (NoSuchElementException ignored) {
            
        }
    }
}
