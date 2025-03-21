package ru.morev.education.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "app")
public class ApplicationProperties {
    private String name;
    private List<String> values;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getValues() { return values; }
    public void setValues(List<String> values) { this.values = values; }
}
