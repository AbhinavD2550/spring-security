package com.spring.security.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig  {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
	
		
//		UserDetails normalUser= User.builder()
//				.username("Normal")
//				.password("normal")
//				.roles("NORMAL").build();
//		
		
		UserDetails normalUser= User
				.withUsername("Normal")
				.password(passwordEncoder().encode("normal123"))
				.roles("normal")
				.build();
		
		
		UserDetails adminUser= User
				.withUsername("Admin")
				.password(passwordEncoder().encode("admin123"))
				.roles("admin")
				.build();
		
		
		InMemoryUserDetailsManager inmemoryuserdetailsmanager=new InMemoryUserDetailsManager(normalUser,adminUser);
		return inmemoryuserdetailsmanager;
			
//		UserDetails adminUser = User.builder().username("Admin")
//				.password("admin")
//				.roles("Admin")
//				.build();
////		
//	InMemoryUserDetailsManager inMemoryUserDetailsManager =	new InMemoryUserDetailsManager(normalUser,adminUser);
//	return inMemoryUserDetailsManager;
//		
	}
	
	
	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.csrf().disable()
//		.authorizeHttpRequests()
//		
//		.requestMatchers("/home/admin")
//		.hasAnyAuthority("Admin")
//		.requestMatchers("/home/normal")
//		.hasRole("Normal")
//		
//		.requestMatchers("/home/public")
//		.permitAll()
//		.anyRequest()
//		.authenticated()
//		.and()
//		.formLogin();
//		
//		return httpSecurity.build();		
//		
//		
//	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpsecurity) throws Exception
	{
		httpsecurity.csrf().disable().authorizeHttpRequests()
		.requestMatchers("/home/admin").hasRole("admin")
		.requestMatchers("/home/normal").hasRole("normal")
		.requestMatchers("/home/public").permitAll()
		.anyRequest().authenticated()
		.and().formLogin();
		return httpsecurity.build();
	}

}
