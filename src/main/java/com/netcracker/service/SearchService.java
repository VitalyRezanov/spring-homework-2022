package com.netcracker.service;

import com.netcracker.model.Agent;
import com.netcracker.model.User;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

@Component
public class SearchService {
    public String searchUser(User userSearch, Agent agent , HttpServletRequest request, Resource resource) {
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
