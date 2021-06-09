package com.example.feignribbonclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableFeignClients("com.example.feignribbonclient")
public class FeignRibbonClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignRibbonClientApplication.class, args);
	}
	
	@Autowired
	ProxyForServerApp proxyforserverapp;
	
	@GetMapping("hello")
	public String getTest() {
		
		return proxyforserverapp.getTest();
	}

}
