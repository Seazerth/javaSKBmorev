package ru.morev.education.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.morev.education.dto.UserDto;
import ru.morev.education.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid UserDto userDto) {
        userService.register(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Пользователь успешно зарегистрирован!");
    }
}
