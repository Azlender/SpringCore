package com.example.demo.notify;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//отдельный класс для валидатора, чтобы при добавлении нового сервиса каждый раз не редактировать sender
@Component
public class NotificationTypeValidator {

    private final NotificationService emailService;
    private final NotificationService smsService;

    public NotificationTypeValidator(@Qualifier("email") NotificationService emailService,
                                     @Qualifier("sms") NotificationService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }
    //выбор типа отправки
    public NotificationService getNotificationType(String type) {
        switch (type.toLowerCase()) {
            case "email":
                return emailService;
            case "sms":
                return smsService;
            default:
                return emailService; // либо возвращать какой то дефолтный тип либо ошибку о некорректном сервисе
                //throw new UnknownServiceException("Unknown notification type: " + type);
        }
    }
}
