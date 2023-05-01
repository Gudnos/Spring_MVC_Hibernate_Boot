package ru.spring.Spring_MVC_Hibernate_Boot.service;



import ru.spring.Spring_MVC_Hibernate_Boot.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    void updateUser(User user);

    User getUser(Long id);

    void deleteUser(User user);
}
