package com.sudobuild.email_tutorial.services;

import com.sudobuild.email_tutorial.models.EmailModel;

public interface EmailService {
    String sendEmail(EmailModel emailDetails);

    String sendEmailWithAttachment(EmailModel emailDetails);
}
