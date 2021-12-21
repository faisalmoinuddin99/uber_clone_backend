package com.upgrad.uber.clone;

import com.upgrad.uber.clone.dao.UserDao;
import com.upgrad.uber.clone.entities.Booking;
import com.upgrad.uber.clone.entities.Users;
import com.upgrad.uber.clone.exceptions.BadCredentialsException;
import com.upgrad.uber.clone.services.AdminService;
import com.upgrad.uber.clone.services.InitService;
import com.upgrad.uber.clone.services.InitServiceImpl;
import com.upgrad.uber.clone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UberCloneApplication {


	public static void main(String[] args) throws BadCredentialsException {
	ApplicationContext context = SpringApplication.run(UberCloneApplication.class, args);

	UserService userService = context.getBean(UserService.class) ;
	Users users = new Users() ;
	users.setFirstName("Faisal");
	users.setEmail("faisal25march@gmail.com");
	users.setLastName("suleman");
	users.setMobileNo("8692927930");
	users.setPassword("faisalfacebook");
	users.setWalletMoney(500.00f);
	userService.createUser(users) ;
	System.out.println(userService.getUser(users));
	}
	@Bean
	CommandLineRunner init (InitService initService){
		return args -> {
			initService.start();
		};
	}


}
