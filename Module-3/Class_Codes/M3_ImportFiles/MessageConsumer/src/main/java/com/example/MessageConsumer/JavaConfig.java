package com.example.MessageConsumer;

import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@Configuration
public class JavaConfig 
{
	@Bean
	public RestTemplate getTemplate()
	{
		return new RestTemplate();
	}
}
