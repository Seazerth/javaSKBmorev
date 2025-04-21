package ru.morev.education.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain disableSecurity(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // ❌ отключаем CSRF
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()) // ✅ разрешаем всё
                .httpBasic(httpBasic -> httpBasic.disable()) // ❌ отключаем basic auth
                .formLogin(form -> form.disable()); // ❌ отключаем форму входа

        return http.build();
    }
}
