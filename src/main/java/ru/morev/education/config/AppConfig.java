package ru.morev.education.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationPropertiesScan("ru.morev.education.properties") // Сканируем нужный пакет
public class AppConfig {
}
