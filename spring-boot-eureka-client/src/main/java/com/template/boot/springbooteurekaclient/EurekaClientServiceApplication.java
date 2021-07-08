package com.template.boot.springbooteurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*
Inspired from: https://medium.com/swlh/spring-cloud-service-discovery-with-eureka-16f32068e5c7
*/
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientServiceApplication.class, args);
	}

}
