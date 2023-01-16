package com.pi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.pi.demo.model") 
@EnableJpaRepositories("com.pi.demo.repository")
public class MysbappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysbappApplication.class, args);
	}

}
