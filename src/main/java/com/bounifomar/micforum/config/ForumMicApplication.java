package com.bounifomar.micforum.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.bounifomar.micforum")
@EntityScan(basePackages = "com.bounifomar.micforum")

public class ForumMicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumMicApplication.class, args);
		
		
	}

}
