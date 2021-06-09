package com.example;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="feign-server-app",url="http://localhost:9092")
public interface ProxyForMsApp4 {
	
	@GetMapping("test1")
	public String callTest();
	
	@GetMapping("test2")
	public String callTest2();
	
	@GetMapping("test3")
	public String callTest3();

}