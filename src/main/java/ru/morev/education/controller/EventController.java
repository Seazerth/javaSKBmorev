package ru.morev.education.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.morev.education.service.EventService;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping("/normal")
    public void normal() {
        eventService.publishNormalEvent();
    }

    @PostMapping("/async")
    public void async() {
        eventService.publishAsyncEvent();
    }

    @PostMapping("/transactional")
    public void transactional() {
        eventService.publishTransactionalEvents();
    }
}
