package ru.morev.education.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/hello")
    public String hello() {
        return "Привет, мир!";
    }

    @GetMapping("/status")
    public String status() {
        return "Сервис работает!";
    }
}
