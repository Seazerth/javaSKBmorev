package ru.morev.education.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HeaderController {

    @GetMapping("/headers")
    public String getHeaders(Model model, HttpServletRequest request) {
        try {
            Map<String, String> headers = new HashMap<>();
            Enumeration<String> headerNames = request.getHeaderNames();

            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                headers.put(name, request.getHeader(name));
            }

            model.addAttribute("headers", headers);
            return "headers";  // Убедитесь, что файл headers.html существует в templates
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при обработке заголовков", e);
        }
    }
}