package com.netcracker.service;

import com.netcracker.model.User;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

@Component
public class UserService {
    public String addUser(User user, Resource resource) {
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
