package com.cg.bs.vt.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableEurekaClient
@EnableMongoRepositories(basePackages="com.cg.bs.vt")
@ComponentScan(basePackages="com.cg.bs.vt")
@SpringBootApplication
public class ViewTransactionsApplication
{
		public static void main(String[] args) {
			SpringApplication.run(ViewTransactionsApplication.class, args);
		}
}
