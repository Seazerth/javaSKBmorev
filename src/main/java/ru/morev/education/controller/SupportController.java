package ru.morev.education.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupportController {

    @RolesAllowed("support")
    @GetMapping("/support/api")
    public String supportApi(Authentication auth) {
        return "Привет, " + auth.getName() + "! Твоя роль: support 🛠️";
    }
}
