package com.netcracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;

@Component
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    public void sendSimpleEmail(String toAddress, String subject, String message) {

        MimeMessagePreparator simpleMailMessage = newMessage -> {
            newMessage.setRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(toAddress)
            );
            newMessage.setFrom("getahur.rezanov@gmail.com");
            newMessage.setSubject(subject);
            newMessage.setText(message);
        };
        emailSender.send(simpleMailMessage);
    }
}