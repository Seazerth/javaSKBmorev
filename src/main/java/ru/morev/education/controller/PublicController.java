package ru.morev.education.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {

    @GetMapping("/public/api")
    public String publicApi() {
        return "Доступ разрешён для всех 👋";
    }
}
