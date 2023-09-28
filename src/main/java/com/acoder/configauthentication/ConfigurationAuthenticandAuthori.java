package com.acoder.configauthentication;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class ConfigurationAuthenticandAuthori {

	/**
	 * @return BCryptpasswordencoder format
	 */
	@Bean 
	PasswordEncoder encoder() { 
		return new BCryptPasswordEncoder(); 
		}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authz) -> authz.anyRequest().authenticated()).httpBasic(withDefaults());
		return http.build();
	}

	@Bean
	UserDetailsService userDetailsService() {

	
		UserDetails  admin = User.builder()
				.username("ANJANEYULU")
				.password(encoder().encode("ANJInaik"))
				.roles("ADMIN")
				.authorities("ADMIN")
				.build();
		UserDetails employee= User.builder()
				  .username("somla")
				  .password("{NOOP}SOMLA")
				  .roles("EMPLOYEE")
				  .authorities("EMPLOYEE","ADMIN")
				  .build();
		
		UserDetails  student = User.builder()
				.username("manthru")
				.password(encoder().encode("MATHRU"))
				.roles("STUDENT")
				.authorities("STUDENT","ADMIN")
				.build();
		UserDetails  manager = User.builder()
				.username("lakshmi")
				.password(encoder().encode("LAKSHMI"))
				.roles("MANAGER")
				.authorities("MANAGER","ADMIN")
				.build();
		return new InMemoryUserDetailsManager(admin,employee,student,manager);
	}
}
