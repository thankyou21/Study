package com.cg.bs.cp.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableEurekaClient
@EnableMongoRepositories(basePackages="com.cg.bs.cp")
@ComponentScan(basePackages="com.cg.bs.cp")
@SpringBootApplication
public class ChangePasswordApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChangePasswordApplication.class, args);
	}
}
