package ru.morev.education.service;

import org.springframework.stereotype.Service;
import ru.morev.education.dto.UserDto;

@Service
public class UserService {

    public void register(UserDto userDto) {
        System.out.println("Регистрация пользователя: " + userDto.getEmail());
    }
}
