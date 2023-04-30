package ru.spring.Spring_MVC_Hibernate_Boot.dao;



import ru.spring.Spring_MVC_Hibernate_Boot.models.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(Long id);

    void deleteUser(User user);
}
