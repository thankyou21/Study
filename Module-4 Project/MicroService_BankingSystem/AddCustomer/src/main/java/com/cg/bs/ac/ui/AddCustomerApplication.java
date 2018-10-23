package com.cg.bs.ac.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@EnableEurekaClient
@EnableMongoRepositories(basePackages="com.cg.bs.ac")
@ComponentScan(basePackages="com.cg.bs.ac")
@SpringBootApplication
public class AddCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddCustomerApplication.class, args);
	}
}
