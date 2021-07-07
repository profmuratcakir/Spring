package com.SpringCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"controller","service"})
@EntityScan("model")
@EnableJpaRepositories("repository")
public class SpringCrudApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCrudApplication.class, args);
	}
	
}
