package ru.morev.education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final MessageService emailService;
    private final MessageService smsService;
    private MessageService pushService;

    @Autowired
    public NotificationService(@Qualifier("emailService") MessageService emailService,
                               @Qualifier("SMSService") MessageService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    @Autowired
    public void setPushService(@Qualifier("SMSService") MessageService pushService) {
        this.pushService = pushService;
    }

    public void notifyAllUsers(String message) {
        emailService.sendMessage(message);
        smsService.sendMessage(message);
        pushService.sendMessage(message);
    }
}
