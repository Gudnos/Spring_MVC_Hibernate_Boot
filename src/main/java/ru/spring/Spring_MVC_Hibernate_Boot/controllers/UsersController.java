package ru.spring.Spring_MVC_Hibernate_Boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.spring.Spring_MVC_Hibernate_Boot.models.User;
import ru.spring.Spring_MVC_Hibernate_Boot.service.UserService;


@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/")
    public String showAllUsers(Model model) {

        model.addAttribute("allUsers", userService.getAllUsers());

        return "all-users";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {

        model.addAttribute("user", new User());

        return "user-info";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {

        userService.saveUser(user);

        return "redirect:/";
    }

    @RequestMapping("/update/{id}")
    public String updatePage(@PathVariable("id") long id, Model model) {

        model.addAttribute("user", userService.getUser(id));

        return "update-info";
    }


    @RequestMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {

        userService.updateUser(user);

        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {

        User user = userService.getUser(id);
        userService.deleteUser(user);

        return "redirect:/";
    }
}
