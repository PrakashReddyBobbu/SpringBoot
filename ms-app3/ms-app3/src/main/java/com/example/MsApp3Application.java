package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import brave.sampler.Sampler;


//Feign Client application to MS4APplication
@SpringBootApplication
@RestController
@EnableFeignClients("com.example.msapp3")
public class MsApp3Application {

	public static void main(String[] args) {
		SpringApplication.run(MsApp3Application.class, args);
	}
	
	@Autowired
	ProxyForMsApp4 proxyforms4app;
	
	@GetMapping("hello")
	public String hello() {
		
		Logger logger = LoggerFactory.getLogger(getClass());
		
		logger.info("{}", "unique id");	
		
		String response_from_app4 = proxyforms4app.callTest();
		

		String response_from_app4_2 = proxyforms4app.callTest2();
		
		
		String response_from_app4_3 = proxyforms4app.callTest3();
		
		return response_from_app4 +" : " + response_from_app4_2 +" : " + response_from_app4_3;
	}
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	} 
	
}
