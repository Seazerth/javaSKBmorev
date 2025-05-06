package ru.morev.education.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

@Component
@Endpoint(id = "customlog")
public class CustomLogEndpoint {

    @ReadOperation
    public Map<String, String> logInvocation() {
        String time = LocalDateTime.now().toString();
        System.out.println("Custom actuator triggered at: " + time);
        return Map.of("status", "Logged to console", "timestamp", time);
    }
}
