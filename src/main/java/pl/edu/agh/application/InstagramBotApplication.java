package pl.edu.agh.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import pl.edu.agh.controllers.TemporaryAuthenticator;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "pl")
public class InstagramBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstagramBotApplication.class, args);
	}
}
