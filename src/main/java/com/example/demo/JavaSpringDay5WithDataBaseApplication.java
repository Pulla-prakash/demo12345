package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.spring.controller","com.spring.service"})
@EntityScan("com.spring.beans")
@EnableJpaRepositories("com.spring.repository")
public class JavaSpringDay5WithDataBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringDay5WithDataBaseApplication.class, args);
	}

}
