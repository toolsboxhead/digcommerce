package com.ecommerce.specommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpEcommerceApplication.class, args);
	}

}
