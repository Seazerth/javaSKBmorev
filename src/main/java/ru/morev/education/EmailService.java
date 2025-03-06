package ru.morev.education;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService implements MessageService {

    @PostConstruct
    public void init() {
        System.out.println("EmailService создан!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("EmailService уничтожен!");
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("📧 Отправка Email: " + message);
    }
}
