package com.cg.bs.ca.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BankingClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingClientApplication.class, args);
	}
}
