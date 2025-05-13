package com.example.demo.notify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.net.UnknownServiceException;
import java.util.Locale;

@Service
public class NotificationSender {
    private final NotificationTypeValidator typeValidator;

    //создание валидатора
    @Autowired
    public NotificationSender(NotificationTypeValidator typeValidator) {
        this.typeValidator = typeValidator;
    }


    public void notifyUser(String type, String message) {
        NotificationService service = typeValidator.getNotificationType(type);
        service.send(message);
    }

    // Внедрение через сеттер
  /*  @Autowired
    public void setSmsService(SmsService smsService) {
        this.service = smsService;
    }*/
}