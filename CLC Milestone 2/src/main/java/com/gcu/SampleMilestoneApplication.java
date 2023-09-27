package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.gcu"})
public class SampleMilestoneApplication {
	public static void main(String[] args) {
		SpringApplication.run(SampleMilestoneApplication.class, args);
	}
}
