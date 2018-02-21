package com.novo.unisys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
//@ComponentScan(basePackageClasses = com.novo.unisys.controller.JobController.class)
public class UnisysApp {

	public static void main(String[] args) {
		SpringApplication.run(UnisysApp.class, args);
	}
}
