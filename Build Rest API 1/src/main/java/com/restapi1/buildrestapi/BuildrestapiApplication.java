package com.restapi1.buildrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.restapi1.buildrestapi.controller","com.restapi1.buildrestapi.services" })
@EntityScan("com.restapi1.buildrestapi.entity")
@EnableJpaRepositories("com.restapi1.buildrestapi.repository")
public class BuildrestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuildrestapiApplication.class, args);
	}

}
