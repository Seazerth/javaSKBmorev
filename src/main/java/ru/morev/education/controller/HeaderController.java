package ru.morev.education.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.morev.education.service.HeaderService;

import java.util.Map;

@Controller
public class HeaderController {

    private final HeaderService headerService;

    public HeaderController(HeaderService headerService) {
        this.headerService = headerService;
    }

    @GetMapping("/headers")
    public String getHeaders(Model model, HttpServletRequest request) {
        Map<String, String> headers = headerService.extractHeaders(request);
        model.addAttribute("headers", headers);
        return "headers";
    }
}
