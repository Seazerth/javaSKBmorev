package ru.morev.education;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class SMSService implements MessageService {

    @PostConstruct
    public void init() {
        log.info("SMSService создан!");
    }

    @PreDestroy
    public void destroy() {
        log.info("SMSService уничтожен!");
    }

    @Override
    public void sendMessage(String message) {
        log.info("📩 Отправка SMS: {}", message);
    }
}
