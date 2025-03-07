package com.store.user_service.domain.ports.out;

public interface IEmailSenderPort {

    void sendEmail(String to, String subject, String body);

}
