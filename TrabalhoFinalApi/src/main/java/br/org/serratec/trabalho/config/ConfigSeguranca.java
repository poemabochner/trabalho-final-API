package br.org.serratec.trabalho.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.org.serratec.trabalho.security.JWTAuthenticationFilter;
import br.org.serratec.trabalho.security.JWTAuthorizationFilter;
import br.org.serratec.trabalho.security.JWTUtil;

@Configuration
public class ConfigSeguranca extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	JWTUtil jwtUtil;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers("/public/**").permitAll().antMatchers("/funcionarios").permitAll()
				.antMatchers("/funcionarios/salarios-por-idade").permitAll()
				.antMatchers(HttpMethod.GET, "//funcionarios/salario", "/funcionarios/pagina", "/funcionarios/nome")
				.hasAuthority("ADMIN").antMatchers(HttpMethod.GET, "/usuarios").hasAnyAuthority("ADMIN", "USER")
				.antMatchers(HttpMethod.POST, "/usuarios").hasAuthority("ADMIN").anyRequest().authenticated().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().cors().and().csrf()
				.disable();
		http.addFilter(new JWTAuthenticationFilter(this.authenticationManager(), jwtUtil));
		http.addFilter(new JWTAuthorizationFilter(this.authenticationManager(), jwtUtil, userDetailsService));
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000/"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfiguration.applyPermitDefaultValues());
		return source;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
