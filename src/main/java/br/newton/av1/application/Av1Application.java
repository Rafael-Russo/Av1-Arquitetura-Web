package br.newton.av1.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"br.newton"})
@EnableMongoRepositories("br.newton.av1.repository")
public class Av1Application {

	public static void main(String[] args) {
		SpringApplication.run(Av1Application.class, args);
	}

}
