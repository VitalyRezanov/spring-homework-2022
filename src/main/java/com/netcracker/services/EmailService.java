package com.netcracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    public void sendSimpleEmail(String toAddress, String subject, String message) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(toAddress);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        emailSender.send(simpleMailMessage);
//        MimeMessage mimeMessage = emailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper;
//        try {
//            mimeMessageHelper = new MimeMessageHelper(mimeMessage,
//                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
//                    StandardCharsets.UTF_8.name());
//            mimeMessageHelper.setTo(toAddress);
//            mimeMessageHelper.setSubject(subject);
//            mimeMessageHelper.setFrom("alexvarte@yandex.ru");
//            mimeMessageHelper.setText(message, false);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        emailSender.send(mimeMessage);
    }
}