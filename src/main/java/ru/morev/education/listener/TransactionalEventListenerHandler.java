package ru.morev.education.listener;

import ru.morev.education.event.TransactionalEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class TransactionalEventListenerHandler {
    @TransactionalEventListener
    public void handle(TransactionalEvent event) {
        if (event.isShouldTrigger()) {
            log.info("Обработка TransactionalEvent: {}", event.getSource());
        } else {
            log.info("Пропущено TransactionalEvent: {}", event.getSource());
        }
    }
}
