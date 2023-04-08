package com.project.Accommodator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**

 The {@code AccomodatorApplication} class is the entry point of the Accommodator application. It is responsible for
 starting the Spring Boot application by running the main method.
 */
@SpringBootApplication
public class AccomodatorApplication {
	/**
	 * The main method of the AccomodatorApplication class is responsible for starting the Spring Boot application
	 * and runs the application by calling the SpringApplication.run() method.
	 *
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(AccomodatorApplication.class, args);
	}
}