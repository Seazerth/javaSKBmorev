package ru.morev.education.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import ru.morev.education.annotation.ValidEmailAndPassword;
import ru.morev.education.annotation.ValidUsername;

@ValidEmailAndPassword
public class UserDto {

    @NotBlank(message = "{email.notblank}")
    private String email;

    @NotBlank(message = "{username.invalid}")
    @Size(min = 3, max = 20, message = "{username.invalid}")
    @ValidUsername
    private String username;

    @NotBlank(message = "{password.notblank}")
    @Size(min = 6, message = "{password.size}")
    private String password;

    // ✅ Геттеры и сеттеры (добавлены, чтобы избежать ошибки)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
