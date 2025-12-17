package com.sudobuild.email_tutorial.controllers;

import com.sudobuild.email_tutorial.models.EmailModel;
import com.sudobuild.email_tutorial.services.EmailService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/sendEmail")
    public String sendSimpleMail(@ModelAttribute EmailModel email) {
        String result;
        if (email.getAttachment() == null) {
            // send as a simple email without attachment...
            result = emailService.sendEmail(email);
        } else {
            // send with an attachment...
            result = emailService.sendEmailWithAttachment(email);
        }

        return result;
    }

}
