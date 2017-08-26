package com.george.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class to bootstrap the application
 * 
 * @author George Zheng
 *
 */
@SpringBootApplication(scanBasePackages = { "com.george.springboot" })
public class SpringBootWeatherApp {
	
	/**
	 * The standard method which is used to start application execution
	 * 
	 * @param args Arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWeatherApp.class, args);
	}
}
