package com.cjc.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WebServiceRedBusAppApplication {

	public static void main(String[] args)
	{
		System.out.println("Consume(Red Bus) side WebService");
		SpringApplication.run(WebServiceRedBusAppApplication.class, args);
	}

	@Bean
	public RestTemplate restT()
	{
		RestTemplate rs=new RestTemplate();
		return rs;
	}
}
