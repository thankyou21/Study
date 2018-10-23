package com.cg.bs.ca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class JavaConfig {
	
	 @Bean 
	   public RestTemplate getTemplate(){
	       return new RestTemplate();
	   }

}
