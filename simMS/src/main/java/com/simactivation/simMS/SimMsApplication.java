package com.simactivation.simMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SimMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimMsApplication.class, args);
	}

}
