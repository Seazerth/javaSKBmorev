package ru.morev.education.service;

import ru.morev.education.event.NormalEvent;
import ru.morev.education.event.AsyncEvent;
import ru.morev.education.event.TransactionalEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventService {

    private final ApplicationEventPublisher publisher;

    public void publishNormalEvent() {
        log.info("Генерация NormalEvent");
        publisher.publishEvent(new NormalEvent("Normal Event"));
    }

    public void publishAsyncEvent() {
        log.info("Генерация AsyncEvent");
        publisher.publishEvent(new AsyncEvent("Async Event"));
    }

    @Transactional
    public void publishTransactionalEvents() {
        log.info("Генерация TransactionalEvents: TRUE и FALSE");
        publisher.publishEvent(new TransactionalEvent("TRUE Event", true));
        publisher.publishEvent(new TransactionalEvent("FALSE Event", false));
    }
}
