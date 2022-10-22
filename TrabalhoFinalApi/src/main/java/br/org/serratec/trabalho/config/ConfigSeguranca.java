//package br.org.serratec.trabalho.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
//@Configuration
//public class ConfigSeguranca extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("goku").password("{noop}careca").roles("ADMIN");
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeHttpRequests().antMatchers("/api/produto").permitAll().anyRequest()
//				.authenticated().and().httpBasic().and().cors().and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//	}
//
////	@Bean
////	CorsConfigurationSource corsConfigurationSource() {
////		CorsConfiguration corsConfiguration = new CorsConfiguration();
////		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000/"));
////		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD"));
////		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////		source.registerCorsConfiguration("/**", corsConfiguration.applyPermitDefaultValues());
////		return source;
////	}
//}
