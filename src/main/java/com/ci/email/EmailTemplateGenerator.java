package com.ci.email;

import org.springframework.stereotype.Component;

@Component
public class EmailTemplateGenerator {

    private final String SIGNATURE = "Best Regards,<br>Chandika Innov LLP";
    private final String LOGOURL = "https://chandikainnov.com/wp-content/uploads/2025/02/chandrika1.png";
    private final String PARAGRAPH = "We are pleased to inform you about the upcoming course.";
    private final String COURSEDETAILS = "Java Spring Boot - Advanced Level";
    private final String LINKTEXT = "Click here to learn more";
    private final String LINKURL = "https://chandikainnov.com/";
    private final String FOOTER = "You are receiving this email because you have enrolled in our program.";

    public String generateEmailTemplate(String userName) {
        return "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<style>" +
                "   body { font-family: Arial, sans-serif; }" +
                "   .container { width: 100%; max-width: 600px; margin: 0 auto; padding: 20px; border: 1px solid #ddd; }" +
                "   .logo { text-align: center; margin-bottom: 20px; }" +
                "   .content { padding: 10px; }" +
                "   .signature { margin-top: 20px; font-style: italic; }" +
                "   .footer {  text-align: center; color: #777777; font-size: 12px; margin-top: 30px; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='container'>" +
                "   <div class='logo'>" +
                "       <img src='" + LOGOURL + "' alt='Company Logo' width='150' />" +
                "   </div>" +
                "   <div class='content'>" +
                "       <p>Dear " + userName + ",</p>" +
                "       <p>" + PARAGRAPH + "</p>" +
                "       <p><strong>Course Details:</strong> " + COURSEDETAILS + "</p>" +
                "       <p><a href='" + LINKURL + "'>" + LINKTEXT + "</a></p>" +
                "   </div>" +
                "   <div class='signature'>" +
                "       <p>" + SIGNATURE + "</p>" +
                "   </div>" +
                "</div>" +
                "<div class='footer'>" +
                "   <p>" + FOOTER + "</p>" +
                "</div>" +
                "</body>" +
                "</html>";
    }

}
