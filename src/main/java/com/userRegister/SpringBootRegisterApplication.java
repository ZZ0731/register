package com.userRegister;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages= {"com.userRegister.mapper"})
public class SpringBootRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRegisterApplication.class, args);
	}

}
