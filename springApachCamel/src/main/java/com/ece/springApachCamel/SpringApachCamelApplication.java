package com.ece.springApachCamel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ImportResource({"apache-camel-choice-example.xml"})
@EnableScheduling
public class SpringApachCamelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApachCamelApplication.class, args);
	}

}
