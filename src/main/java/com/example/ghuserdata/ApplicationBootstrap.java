package com.example.ghuserdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class ApplicationBootstrap {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationBootstrap.class, args);
	}
}
