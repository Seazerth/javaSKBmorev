package ru.morev.education.listener;

import ru.morev.education.event.NormalEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NormalEventListener {
    @EventListener
    public void handle(NormalEvent event) {
        log.info("Обработка NormalEvent: {}", event.getSource());
    }
}
