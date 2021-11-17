package com.order.controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.order.dto.productDTO;
@FeignClient(name="productms",url="http://localhost:8000") /* Feign client connection */
public interface ProductFeign {
	
	@GetMapping(value="/api/{prodId}",  produces = MediaType.APPLICATION_JSON_VALUE)
	productDTO getProduct(@PathVariable("prodId") String prodId) throws Exception;
	@PutMapping(value = "/api/{prodId}",  produces = MediaType.APPLICATION_JSON_VALUE)
	String updatestock(@PathVariable String prodId,@RequestBody Integer quantity ) throws Exception;
}


/*
				Commands to run in created EC2 instance to install Java 11.

sudo rpm --import https://yum.corretto.aws/corretto.key 
sudo curl -L -o /etc/yum.repos.d/corretto.repo https://yum.corretto.aws/corretto.repo 
sudo yum install -y java-11-amazon-corretto-devel

*/