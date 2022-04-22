package com.ecommerce.orderservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.orderservice.entity.User;



@FeignClient(name = "user-service", url = "http://localhost:8081/")
public interface UserClient {

	 @GetMapping(value = "/users")
	    public User getUserByName(@RequestParam("name") String userName);

	public User getUserById(Long userId);
}
