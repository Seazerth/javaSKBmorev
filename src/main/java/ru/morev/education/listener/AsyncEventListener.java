package ru.morev.education.listener;

import ru.morev.education.event.AsyncEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AsyncEventListener {
    @Async
    @EventListener
    public void handle(AsyncEvent event) {
        log.info("Асинхронная обработка AsyncEvent: {}", event.getSource());
    }
}
