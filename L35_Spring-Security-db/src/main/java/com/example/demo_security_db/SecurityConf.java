package com.example.demo_security_db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class SecurityConf extends WebSecurityConfigurerAdapter {

    @Autowired
    DemoUserService demoUserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(demoUserService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf() // .disable()  added to bypass unsafe API calls which are not authenticated, not to be in production environment as it makes your APIs vulnerable to csrf attacks
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/student/**").hasAuthority("student")
                .antMatchers("/librarian/**").hasAuthority("librarian")
                .antMatchers("/user/**").permitAll()
                .anyRequest().authenticated()
//                .anyRequest().authenticated()
//                .anyRequest().permitAll()
                .and()
                .formLogin();
    }


}
