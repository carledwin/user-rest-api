package com.carledwin.ti.user.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.carledwin.ti.user.rest.api")
public class UserRestApiApp {

	public static void main(String[] args) {
		SpringApplication.run(UserRestApiApp.class, args);
	}
}
