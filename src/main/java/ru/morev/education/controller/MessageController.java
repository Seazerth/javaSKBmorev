package ru.morev.education.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;
import ru.morev.education.model.Message;

@RestController
@RequestMapping("/send")
public class MessageController {

    private final RabbitTemplate rabbitTemplate;

    public MessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public String send(@RequestBody Message message) {
        rabbitTemplate.convertAndSend("edu.queue", message);
        return "✅ Сообщение отправлено!";
    }
}
