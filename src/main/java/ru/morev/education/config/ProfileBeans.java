package ru.morev.education.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.beans.factory.annotation.Value;
import java.util.Optional;

@Configuration
public class ProfileBeans {

    @Bean
    @Profile("test") // Создаётся только в "test" профиле
    public String testOnlyBean() {
        System.out.println("✔️ TestOnlyBean создан!");
        return "TestOnlyBean";
    }

    @Bean
    public String dependentBean(Optional<String> testOnlyBean) {
        if (testOnlyBean.isPresent()) {
            System.out.println("✔️ DependentBean создан, так как TestOnlyBean существует!");
            return "DependentBean";
        } else {
            System.out.println("⚠️ DependentBean НЕ создан, так как TestOnlyBean отсутствует.");
            return null;
        }
    }

    @Bean
    public String conditionalBean(@Value("${example.test:default}") String exampleTest) {
        if (!"default".equals(exampleTest)) {
            System.out.println("✔️ ConditionalBean создан, так как EXAMPLE_TEST не 'default'!");
            return "ConditionalBean";
        }
        return null;
    }
}