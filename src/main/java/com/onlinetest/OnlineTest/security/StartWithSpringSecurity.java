package com.onlinetest.OnlineTest.security;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class StartWithSpringSecurity extends WebSecurityConfigurerAdapter {
	
	
	@Resource(name = "service")
    private UserDetailsService userDetailsService;
	
	private final Log logger = LogFactory.getLog(StartWithSpringSecurity.class);
	
	@Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

	@Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(encoder());
    }
	
	 @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }
	
	@Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("Akash").password("{noop}Akash@2141").roles("User")
		.and()
		.withUser("Vikas").password("{noop}Vikas123").roles("Admin");
		
//		auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
		
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		logger.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");

		http
		.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers("/books/*").hasRole("User")
		.antMatchers("/books").hasRole("Admin")
		.and()
		.csrf()
		.disable();
	}

}
