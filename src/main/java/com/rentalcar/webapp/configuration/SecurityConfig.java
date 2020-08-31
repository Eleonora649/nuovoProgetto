package com.rentalcar.webapp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{
	
//	@Autowired
//	public void configure(AuthenticationManagerBuilder auth) throws Exception
//	{
//		//dati recuperati da input e verificato se presenti all'interno del db
//		auth.inMemoryAuthentication()
//		.withUser("jduser").password("jdu@123").authorities("ROLE_USER")
//		.and()
//		.withUser("jdadmin").password("jda@123").authorities("ROLE_USER","ROLE_ADMIN");
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/home").permitAll() //.anyRequest().authenticated()
				.antMatchers("/userPage").access("hasRole('ROLE_USER')")
				.antMatchers("/adminPage").access("hasRole('ROLE_ADMIN')")
				.and()
			.formLogin().loginPage("/loginform")
				.defaultSuccessUrl("/home")
				.failureUrl("/loginform?error")
				.usernameParameter("username").passwordParameter("password")				
				.and()
			.logout().logoutSuccessUrl("/loginform?logout"); 
	}
}
