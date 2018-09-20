package com.onlinetest.OnlineTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.onlinetest.OnlineTest.controller.*;

@SpringBootApplication
@ComponentScan(basePackages="com.onlinetest.OnlineTest.*")
//@EnableJpaRepositories("com.onlinetest.OnlineTest.Entity")
public class OnlineTestApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ApplicationContext = SpringApplication.run(OnlineTestApplication.class, args);
	}
}
