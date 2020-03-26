package ru.shaitanshamma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;

@EnableIntegration
@IntegrationComponentScan
@SpringBootApplication
//@EnableDiscoveryClient
public class MyAwesomeShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAwesomeShopApplication.class, args);
	}

}
