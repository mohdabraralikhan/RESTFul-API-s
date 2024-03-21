package org.nicecharity.application.security;


import java.util.Arrays;

import org.nicecharity.application.user.MyUserDetailsService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig  {

        
        private MyUserDetailsService myUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) 
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .anyRequest()
                        .authenticated())
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/home")
                        .failureUrl("/login?error"))
                .logout(logout -> logout 
                        .logoutSuccessUrl("/login?logout")); 
        return http.build();
    }

     @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }
  
    @Bean
CorsConfigurationSource corsConfigurationSource() {
	CorsConfiguration configuration = new CorsConfiguration();
	configuration.setAllowedOrigins(Arrays.asList("https://localhost:4200"));
	configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	source.registerCorsConfiguration("/**", configuration);
	return source;
}
    
}
