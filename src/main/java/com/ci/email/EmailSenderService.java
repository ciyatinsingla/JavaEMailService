package com.ci.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String emailUsername;

    public void sendEmail(String toRecipient, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailUsername);
        message.setSubject(subject);
        message.setTo(toRecipient);
        message.setText(body);

        mailSender.send(message);
        System.out.println("Email sent successfully....");
    }
}
