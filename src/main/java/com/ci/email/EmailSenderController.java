package com.ci.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class EmailSenderController {

    @Autowired
    private EmailSenderService senderService;

    @Value("${test.recipient.email}")
    private String recipientEmailId;

    @GetMapping("/email")
    public String sendMail() {
        return senderService.sendEmail(recipientEmailId, "This is a test email.", "Test Email Body");
    }

    @PostMapping("/email-with-attachment")
    public String sendMailWithAttachment(@RequestParam(required = false) MultipartFile attachment) {
        return senderService.sendEmailWithAttachment(recipientEmailId, "This is a test email.", "Test Email Body", attachment);
    }

    @PostMapping("/email-using-template")
    public String sendMailUsingTemplate(@RequestParam(required = false) MultipartFile attachment) {
        return senderService.sendEmailUsingTemplate(recipientEmailId, "This is a test email using html template.", attachment);
    }
}
