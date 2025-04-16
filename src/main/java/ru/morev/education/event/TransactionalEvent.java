package ru.morev.education.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class TransactionalEvent extends ApplicationEvent {
    private final boolean shouldTrigger;

    public TransactionalEvent(Object source, boolean shouldTrigger) {
        super(source);
        this.shouldTrigger = shouldTrigger;
    }
}
