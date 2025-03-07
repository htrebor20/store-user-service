package com.store.user_service.infrastructure.adapters;

import com.store.user_service.domain.ports.out.IEmailSenderPort;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSenderAdapter implements IEmailSenderPort {
    private final JavaMailSender javaMailSender;
    @Value("${MAIL_USERNAME}")
private String emailUser;
    @Override
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom(emailUser);
        javaMailSender.send(message);
    }
}
