package com.iot.iotdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = { "com.iot.iotdemo.repository"})
public class IotdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotdemoApplication.class, args);
	}

}
