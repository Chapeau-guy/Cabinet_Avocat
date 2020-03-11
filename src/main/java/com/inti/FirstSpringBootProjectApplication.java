package com.inti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
 * @SpringBootConfiguration : @Configuration
 * @EnableAutoConfiguration
 * @ComponentScan : permet de scanner tous les composants et les dérivés dans le package principal
 * Elle va chercher tous ce qui est annoté par @Service, @RestController, @Configuration, @Controller
 * @Repository...
 */
public class FirstSpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootProjectApplication.class, args);
	}

}
