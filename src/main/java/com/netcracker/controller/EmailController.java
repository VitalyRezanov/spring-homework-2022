package com.netcracker.controller;

import com.netcracker.model.Mail;
import com.netcracker.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmailController {

    @GetMapping("/send-message")
    public String sendMessage(Model model) {
        model.addAttribute("emailAttribute",new Mail());
        return "sendEmail";
    }

    @Autowired
    EmailService emailService;

    @PostMapping("/send-message")
    public String sendMessagePost(@ModelAttribute Mail mail) {
        emailService.sendSimpleEmail(mail.getEmail(), mail.getTitle(), mail.getText());
        return "sendEmailPost";
    }

}
