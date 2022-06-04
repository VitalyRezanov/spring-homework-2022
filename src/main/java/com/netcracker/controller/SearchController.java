package com.netcracker.controller;

import com.netcracker.model.User;
import com.netcracker.model.Agent;
import com.netcracker.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

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

    @Autowired
    SearchService searchService;
    @PostMapping("/search-user")
    public String searchUserSubmit(@ModelAttribute User userSearch,
                                   @ModelAttribute Agent agent , HttpServletRequest request) {
        return searchService.searchUser(userSearch, agent , request,resource);
    }
}
