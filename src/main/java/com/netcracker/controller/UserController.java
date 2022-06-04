package com.netcracker.controller;

import com.netcracker.model.User;
import com.netcracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Value("/users.txt")
    Resource resource;
    @GetMapping("/input-user")
    public String userForm(Model model) {
        model.addAttribute("userAttribute", new User());
        return "addUser";
    }

    @Autowired
    UserService userService;

    @PostMapping("/input-user")
    public String userSubmit(@ModelAttribute User user) {
        return userService.addUser(user, resource);
    }
}
