package ru.morev.education;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    @Autowired
    private MessageService emailService;

    private final MessageService smsService;

    private MessageService pushService;

    @Autowired
    public void setPushService(MessageService pushService) {
        this.pushService = pushService;
    }
}
