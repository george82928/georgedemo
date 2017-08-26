package com.george.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.george.springboot"})
public class SpringBootWeatherApp {
	public static void main(String[] args) {
        SpringApplication.run(SpringBootWeatherApp.class, args);
    }
}
