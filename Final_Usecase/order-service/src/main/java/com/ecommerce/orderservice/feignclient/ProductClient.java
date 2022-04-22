package com.ecommerce.orderservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.orderservice.entity.Product;



@FeignClient(name = "product-service", url = "http://localhost:4200/")
public interface ProductClient {

    @GetMapping(value = "/products_byname")
    public Product getAllProductsByName(@RequestParam ("name") String name);

    
    @GetMapping (value = "/products/{id}")
	public Product getProductById(Long productId);

}


