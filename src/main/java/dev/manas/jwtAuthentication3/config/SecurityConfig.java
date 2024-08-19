package dev.manas.jwtAuthentication3.config;

import dev.manas.jwtAuthentication3.security.JwtAuthenticationEntryPoint;
import dev.manas.jwtAuthentication3.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private JwtAuthenticationFilter filter;

    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception
    {
        //configuration
        httpSecurity.csrf(csrf->csrf.disable()).cors(cors->cors.disable()).authorizeHttpRequests(auth-> auth.requestMatchers("/home/**").authenticated().requestMatchers("/auth/login").permitAll().anyRequest().authenticated()).exceptionHandling(ex->ex.authenticationEntryPoint(jwtAuthenticationEntryPoint)).sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        httpSecurity.addFilter(filter);
        return httpSecurity.build();
    }
}
