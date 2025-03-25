package ru.morev.education;

import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class NotificationService {

    @Autowired
    private MessageService emailService;

    private final MessageService SMSService; // Название переменной соответствует классу

    private MessageService pushService;

    @Autowired
    public void setPushService(@Qualifier("emailService") MessageService pushService) {
        this.pushService = pushService;
    }

    @PreDestroy
    public void destroy() {
        log.info("Уничтожение NotificationService...");
        SMSService.sendMessage("Successful sending");
        emailService.sendMessage("Successful sending");
        pushService.sendMessage("Successful sending");
    }
}
