package com.genius7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class Genius7Application {

	public static void main(String[] args) {
		SpringApplication.run(Genius7Application.class, args);
	}

}
