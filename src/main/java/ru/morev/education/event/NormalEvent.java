package ru.morev.education.event;

import org.springframework.context.ApplicationEvent;

public class NormalEvent extends ApplicationEvent {
    public NormalEvent(Object source) {
        super(source);
    }
}
