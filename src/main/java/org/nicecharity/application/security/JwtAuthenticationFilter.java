package org.nicecharity.application.security;

import java.io.IOException;
import java.sql.Date;

import org.nicecharity.application.Utils.Utils;
import org.nicecharity.application.user.LoginRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.nicecharity.application.user.User;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
@Value("${SECRET_KEY}")
private String secretKey;
    


private final AuthenticationManager authenticationManager;

public JwtAuthenticationFilter(AuthenticationManagerBuilder auth) {
        this.authenticationManager = auth.getOrBuild(); 
    }
    
    

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
                try {
                LoginRequest loginRequest = Utils.extractLoginRequestFromBody(request);
                String username = loginRequest.getUsername();
                String password = loginRequest.getPassword();
                            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
                            return getAuthenticationManager().authenticate(token);

                }catch (Exception e) {
        System.err.println("Caught Exception: " + e);
        throw new AuthenticationServiceException("Failed to authenticate", e); // Re-throw exception
    }

    }

    @Override 
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        String username = ((User) authResult.getPrincipal()).getUsername();
        String token = generateJwtToken(username); 
        response.addHeader("Authorization", "Bearer " + token); 

        super.successfulAuthentication(request, response, chain, authResult);
    }

    private String generateJwtToken(String username) {

           
    
        JwtBuilder builder = Jwts.builder()
        .setSubject(username)
        .setExpiration(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24)))
               .setIssuedAt(new Date(0))
               .setIssuer("nicecharity.org")
               .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), Jwts.SIG.HS256);
    
  
        return builder.compact();
    }
    
    

}

