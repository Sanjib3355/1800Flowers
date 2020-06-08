package com.zensar.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.zensar.api", "com.zensar.api.controller", "com.zensar.api.service"})
public class UserApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserApplication.class, args);

	}
}