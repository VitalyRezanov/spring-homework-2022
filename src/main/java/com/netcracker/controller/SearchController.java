package com.netcracker.controller;

import com.netcracker.model.User;
import com.netcracker.model.Agent;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;

@Controller
public class SearchController {
    @Value("/users.txt")
    Resource resource;

    @GetMapping("/search-user")
    public String searchUserForm(Model model, HttpServletRequest request) {
        model.addAttribute("userAttributeSearch", new User());
        model.addAttribute("UserAgent", new Agent());
        return "searchUser";
    }

    @PostMapping("/search-user")
    public String searchUserSubmit(@ModelAttribute User userSearch,
                                   @ModelAttribute Agent agent , HttpServletRequest request) {
        UserAgent userAgent = new UserAgent(request.getHeader("User-Agent"));
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(resource.getFile()))))
        {
            String line = br.readLine();
            String name = userSearch.getFirstName() + "," + userSearch.getSecondName();
            String[] subjects = line.split("/");
            agent.setUserAgent( "Browser :" + userAgent.getBrowser().getName() +
                    " Version :" + userAgent.getBrowserVersion().getVersion());
            agent.setTime(new Date().toString());
            for (int i = 0; i < subjects.length; ++i) {
                if (subjects[i].contains(name)) {
                    String[] subject = subjects[i].split(",");
                    userSearch.setLastName(subject[2]);
                    userSearch.setSalary(Long.parseLong(subject[3]));
                    userSearch.setEmail(subject[4]);
                    userSearch.setJobPlace(subject[5]);
                    return "postSearchUser";
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return "userNotFound";
    }
}
