package org.nicecharity.application.security;


import java.util.Arrays;

import org.nicecharity.application.user.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig  {

        
@Autowired
MyUserDetailsService userDetailsService;
        @Autowired
        private AuthenticationManager authenticationManager;
    @Bean
    public DefaultSecurityFilterChain securityFilterChain(HttpSecurity http,AuthenticationManagerBuilder auth) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/", "/login", "/signup", "/home").permitAll()
                        .anyRequest().authenticated())
                .formLogin(login -> login.disable()) // Disable form login since using JWT
                .logout(logout -> logout.permitAll())
                .addFilterBefore(new JwtAuthenticationFilter(auth), UsernamePasswordAuthenticationFilter.class)
                .build();
      }
      


     @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
        
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        return auth.build(); 
    }
    @Bean
CorsConfigurationSource corsConfigurationSource() {
	CorsConfiguration configuration = new CorsConfiguration();
	configuration.setAllowedOrigins(Arrays.asList("https://localhost:4200"));
	configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","UPDATE"));
	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	source.registerCorsConfiguration("/**", configuration);
	return source;
}
    
}
