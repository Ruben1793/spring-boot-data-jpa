package com.bolsadeideas.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
		UserBuilder users = User.withDefaultPasswordEncoder();
		build.inMemoryAuthentication()
		.withUser(users.username("admin").password("1234").roles("ADMIN","USER"))
		.withUser(users.username("andres").password("12345").roles("USER"));
	}

}
