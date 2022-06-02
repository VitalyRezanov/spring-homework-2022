package com.netcracker.controller;

import com.netcracker.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.*;

@Controller
public class UserController {
    @Value("/users.txt")
    Resource resource;
    @GetMapping("/input-user")
    public String userForm(Model model) {
        model.addAttribute("userAttribute", new User());
        return "addUser";
    }

    @PostMapping("/input-user")
    public String userSubmit(@ModelAttribute User user) {

        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resource.getFile(), true))))
        {
            bw.write(user.getFirstName() + "," + user.getSecondName() + "," +
                    user.getLastName() + "," + user.getSalary() + "," + user.getEmail() + "," +
                    user.getJobPlace() + "/");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return "postUser";
    }
}
