package ru.morev.education;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service("SMSService")
public class SMSService implements MessageService {

    @PostConstruct
    public void init() {
        System.out.println("SMSService создан!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("SMSService уничтожен!");
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("📩 Отправка SMS: " + message);
    }
}
