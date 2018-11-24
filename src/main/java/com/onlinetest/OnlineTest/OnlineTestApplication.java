package com.onlinetest.OnlineTest;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;


@SpringBootApplication
//@EnableAsync
@ComponentScan(basePackages="com.onlinetest.OnlineTest.*")
//@EnableJpaRepositories("com.onlinetest.OnlineTest.Entity")
public class OnlineTestApplication {

	@Autowired
	DataSource datasource;
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineTestApplication.class, args);
	}
	
	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(datasource);
	}
	
	@Bean
	BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder(10);
	}
	
}
