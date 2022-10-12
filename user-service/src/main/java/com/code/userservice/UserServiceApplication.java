package com.code.userservice;

import com.code.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class UserServiceApplication
{


	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}


}
