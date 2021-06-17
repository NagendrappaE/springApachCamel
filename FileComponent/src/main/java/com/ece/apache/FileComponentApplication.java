package com.ece.apache;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ImportResource({ "filecomponent.xml" })

public class FileComponentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileComponentApplication.class, args);
	}

	@Bean
	public RestTemplate newtemp() {

		return new RestTemplateBuilder().setConnectTimeout(Duration.ofSeconds(10))
				.setReadTimeout(Duration.ofSeconds(10)).build();
	}

}
