package com.htu.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	
//	@Autowired
//	AuthenticationSuccessHandler successHandler;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("Admin").password("{noop}tasbeeh98cs").roles("ADMIN")
			.and()
			.withUser("user1").password("{noop}Tasbeeh@1998").roles("USER");
	}
	
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http
//			.csrf().disable()
//			.authorizeRequests()
//			.antMatchers("/user").hasAnyRole("USER")
//			.antMatchers("/secretary").hasAnyRole("ADMIN")
//			.and().formLogin().loginPage("/login")
//				.successHandler(successHandler)
//			.permitAll()
//			.and().logout();
//	}

}
