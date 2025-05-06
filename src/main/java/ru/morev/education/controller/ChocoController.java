package ru.morev.education.controller;

import org.springframework.web.bind.annotation.*;
import ru.morev.education.service.ChocoService;

@RestController
@RequestMapping("/choco")
public class ChocoController {

    private final ChocoService chocoService;

    public ChocoController(ChocoService chocoService) {
        this.chocoService = chocoService;
    }

    @PostMapping("/buy")
    public String buyChocolate(@RequestParam String type, @RequestParam int amount) {
        chocoService.buyChocolate(type, amount);
        return amount + " " + type + " bought!";
    }
}
