package ru.morev.education;

import ru.morev.education.properties.ApplicationProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {

	private final ApplicationContext context;
	private final ApplicationProperties properties;
	private final Environment environment;

	public ProjectApplication(ApplicationContext context, ApplicationProperties properties, Environment environment) {
		this.context = context;
		this.properties = properties;
		this.environment = environment;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("📢 Активный профиль: " + Arrays.toString(environment.getActiveProfiles()));
		System.out.println("📌 Название приложения: " + properties.getName());
		System.out.println("📜 Конфиг-лист: " + properties.getValues());
	}
}
