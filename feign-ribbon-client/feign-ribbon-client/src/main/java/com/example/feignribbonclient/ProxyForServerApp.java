package com.example.feignribbonclient;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="server-app")
@RibbonClient(name="server-app")
public interface ProxyForServerApp {
	
	@GetMapping("test1")
	public String getTest();

}
