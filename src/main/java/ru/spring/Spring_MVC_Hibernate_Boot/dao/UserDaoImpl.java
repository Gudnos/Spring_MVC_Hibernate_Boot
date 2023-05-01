package ru.spring.Spring_MVC_Hibernate_Boot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.spring.Spring_MVC_Hibernate_Boot.models.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl() {
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {

        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void updateUser(User user) {

        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(User user) {

        User managed = entityManager.merge(user);
        entityManager.remove(managed);
        entityManager.flush();
    }
}
