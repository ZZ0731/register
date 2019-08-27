package com.userRegister;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;

@MapperScan(basePackages= {"com.userRegister.mapper"})
@SpringBootApplication//(exclude = PageHelperAutoConfiguration.class)
public class SpringBootRegisterApplication extends SpringBootServletInitializer{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    	return application.sources(SpringBootRegisterApplication.class);
    	
    }
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRegisterApplication.class, args);
	}

}
