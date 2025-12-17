package com.sudobuild.email_tutorial.services;

import com.sudobuild.email_tutorial.models.EmailModel;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    // Sends simple emails without attachment.
    @Override
    public String sendEmail(EmailModel emailDetails) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailDetails.getFrom());
            message.setTo(emailDetails.getTo());
            message.setSubject(emailDetails.getSubject());
            message.setText(emailDetails.getBody());
            mailSender.send(message);
            return "Email sent successfully.";
        } catch (Exception e) {
            return "An error occurred while sending an email: " + e.getMessage();
        }
    }

    // Sends emails with attachment.
    @Override
    public String sendEmailWithAttachment(EmailModel emailDetails) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(emailDetails.getFrom());
            helper.setTo(emailDetails.getTo());
            helper.setSubject(emailDetails.getSubject());
            helper.setText(emailDetails.getBody(), true);
            helper.addAttachment(emailDetails.getAttachment().getOriginalFilename(), emailDetails.getAttachment());
            mailSender.send(message);

            return "Email sent successfully.";
        } catch (Exception e) {
            return "An error occurred while sending an email: " + e.getMessage();
        }
    }
}
