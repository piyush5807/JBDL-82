package com.example.minor_project1.configs;

import com.example.minor_project1.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConf{

    private static Logger logger = LoggerFactory.getLogger(SecurityConf.class);

    @Autowired
    UserService userService;

    @Bean
    public AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {

        logger.info("Inside authentication manager bean....");

        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder
                .userDetailsService(userService)
                .passwordEncoder(getPE());
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        logger.info("Inside security filter chain bean....");

        return http
                .authorizeHttpRequests(
                        (auth) -> auth
                                .requestMatchers(HttpMethod.POST, "/students/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/students/details/**").hasAuthority("STUDENT")
                                .requestMatchers(HttpMethod.GET, "/student/**").hasAuthority("ADMIN")
                                .requestMatchers("/student/**").hasAuthority("STUDENT")
                                .requestMatchers(HttpMethod.GET, "/books/**").hasAnyAuthority("STUDENT", "ADMIN")
                                .requestMatchers("/books/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/transactions/all/**").hasAuthority("ADMIN")
                                .requestMatchers("/transactions/**").hasAuthority("STUDENT")
                                .requestMatchers(HttpMethod.POST, "/admin/**").hasAuthority("ADMIN")
                                .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    PasswordEncoder getPE(){
        logger.info("Inside password encoder bean....");
        return new BCryptPasswordEncoder();
    }
}
