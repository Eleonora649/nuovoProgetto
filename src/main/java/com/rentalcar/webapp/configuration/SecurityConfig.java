package com.rentalcar.webapp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rentalcar.webapp.service.UserDetailsServiceImp;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImp();
	}
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    };
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
    	DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    	authProvider.setUserDetailsService(userDetailsService());
    	authProvider.setPasswordEncoder(passwordEncoder());
    	return authProvider;
    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
       	auth.authenticationProvider(authenticationProvider());
    }

    @Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http
			.authorizeRequests() 
				.antMatchers("home","/login").permitAll()
				.antMatchers("/userPage").hasAnyRole("customer")
				.antMatchers("/adminPage").hasAnyRole("admin")
		.and()
			.formLogin().loginPage("/login").usernameParameter("email").passwordParameter("password").permitAll()
			.successForwardUrl("/do-login")
			.failureForwardUrl("/loginFailed")
		.and()
			.logout().logoutUrl("/do-logout").permitAll()
		.and()
			.csrf().disable(); 
	}
}







