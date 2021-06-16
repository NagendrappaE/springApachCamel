package com.ece.apache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"filecomponent.xml"})

public class FileComponentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileComponentApplication.class, args);
	}

}
