package com.ci.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailTemplateGenerator emailTemplateGenerator;

    @Value("${spring.mail.username}")
    private String emailUsername;

    public String sendEmail(String toRecipient, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailUsername);
        message.setSubject(subject);
        message.setTo(toRecipient);
        message.setText(body);

        mailSender.send(message);
        return "Email sent successfully....";
    }

    public String sendEmailWithAttachment(String toRecipient, String subject, String body, MultipartFile attachment) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(emailUsername);
            helper.setTo(toRecipient);
            helper.setSubject(subject);
            helper.setText(body, true); // 'true' enables HTML content if needed

            if (attachment != null)
                helper.addAttachment(Objects.requireNonNull(attachment.getOriginalFilename()), attachment);
            mailSender.send(message);
            return "Email sent successfully....";
        } catch (MessagingException e) {
            return "Failed to send email: " + e.getMessage();
        }
    }

    public String sendEmailUsingTemplate(String toRecipient, String subject, MultipartFile attachment) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(emailUsername);
            helper.setTo(toRecipient);
            helper.setSubject(subject);
            helper.setText(emailTemplateGenerator.generateEmailTemplate("Student"), true);

            if (attachment != null)
                helper.addAttachment(Objects.requireNonNull(attachment.getOriginalFilename()), attachment);
            mailSender.send(message);

            return "Email sent successfully....";
        } catch (MessagingException e) {
            return "Failed to send email: " + e.getMessage();
        }
    }
}
