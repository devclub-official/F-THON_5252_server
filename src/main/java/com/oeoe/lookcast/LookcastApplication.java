package com.oeoe.lookcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LookcastApplication {

	public static void main(String[] args) {
		SpringApplication.run(LookcastApplication.class, args);
	}

}
