package ru.shaitanshamma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyAwesomeShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAwesomeShopApplication.class, args);
	}

}
