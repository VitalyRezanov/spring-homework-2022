package com.netcracker.controller;

import com.netcracker.model.Mail;
import com.netcracker.services.EmailService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
public class EmailController {

//    @Autowired
//    JavaMailSender mailSender;

    @GetMapping("/send-message")
    public String sendMessage(Model model) {
        model.addAttribute("emailAttribute",new Mail());
        return "sendEmail";
    }

    @Autowired
    EmailService emailService;


//    @ResponseBody
//    @RequestMapping("/send-message")
//    public String sendSimpleEmail(@ModelAttribute Mail mail) {
//
//        // Create a Simple MailMessage.
//        SimpleMailMessage message = new SimpleMailMessage();
//
//        message.setTo(mail.getEmail());
//        message.setFrom("getahur.rezanov@gmail.com");
//        message.setSubject(mail.getTitle());
//        message.setText(mail.getText());
//
//        // Send Message!
//        mailSender.send(message);
//
//        return "sendEmailPost";
//    }
    @PostMapping("/send-message")
    public String sendMessagePost(@ModelAttribute Mail mail) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(mail.getEmail());
//        message.setSubject(mail.getTitle());
//        message.setText(mail.getText());
//
//        this.mailSender.send(message);
        emailService.sendSimpleEmail(mail.getEmail(), mail.getTitle(), mail.getText());
            //emailService.sendSimpleMessage(mail.getEmail(), mail.getTitle(), mail.getText());

        return "sendEmailPost";
    }

}
