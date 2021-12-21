package com.upgrad.uber.clone;

import com.upgrad.uber.clone.services.InitService;
import com.upgrad.uber.clone.services.InitServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UberCloneApplication {

	public static void main(String[] args) {
	ApplicationContext context = SpringApplication.run(UberCloneApplication.class, args);

	}
	@Bean
	CommandLineRunner init (InitService initService){
		return args -> {
			initService.start();
		};
	}


}
