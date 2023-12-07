package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.gcu.service.LoginService;

@Configuration

public class SecurityConfig
{
	@Autowired
	private LoginService service;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth
					.requestMatchers(new AntPathRequestMatcher("/"), new AntPathRequestMatcher("/login"), new AntPathRequestMatcher("/register"),new AntPathRequestMatcher("/doRegister"), new AntPathRequestMatcher("/css/**"), new AntPathRequestMatcher("/images/**")).permitAll()
					.requestMatchers(new AntPathRequestMatcher("/products/edit/**"), new AntPathRequestMatcher("/products/delete/**"), new AntPathRequestMatcher("/products/creation/**")).hasRole("ADMIN")
					.anyRequest().authenticated())
			.formLogin(form -> form
					.loginPage("/login")
					.usernameParameter("username")
					.passwordParameter("password")
					.permitAll()
					.defaultSuccessUrl("/",true))
			.logout(lo -> lo
					.logoutUrl("/logout")
					.invalidateHttpSession(true)
					.clearAuthentication(true)
					.permitAll()
					.logoutSuccessUrl("/"))
			.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(service)
			.passwordEncoder(new BCryptPasswordEncoder());
	}
}
