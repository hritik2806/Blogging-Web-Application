package com.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.blog.Security.CustomUserDetailService;


@Configuration
@EnableWebSecurity
	public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired    
	CustomUserDetailService customUserDetailsService;
	
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// TODO Auto-generated method stub
			http
			
			        .authorizeRequests()
			        .anyRequest()
			        .authenticated()
			        .and()
			        .httpBasic();
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
			auth.userDetailsService(this.customUserDetailsService).passwordEncoder(passwordEncoder());
		}
		
		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
		
}
