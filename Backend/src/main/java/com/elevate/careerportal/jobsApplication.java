package com.elevate.careerportal;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class jobsApplication {


	public static void main(String[] args) {
		SpringApplication.run(jobsApplication.class, args);
	}



}
