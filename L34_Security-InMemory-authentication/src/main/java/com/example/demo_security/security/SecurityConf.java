package com.example.demo_security.security;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConf extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Karan")
                .password("$2a$10$NzNMihIwkWfFp4d.16Kgv.M56LHoGrOrtLAgnwbHAeyRtcitF.4XC")
                .authorities("student")
                .and()
                .withUser("Rahul")
                .password("$2a$10$0iRRAnJMSkieanJe8or7G.vclgR69QMGWlgdj.d7Ek8olNVl9VXaa")
                .authorities("librarian");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/student/**").hasAuthority("student")
                .antMatchers("/librarian/**").hasAuthority("librarian")
                .antMatchers("/user/**").authenticated()
                .antMatchers("/home/**").permitAll()
                .anyRequest().authenticated()
//                .anyRequest().authenticated()
//                .anyRequest().permitAll()
                .and()
                .formLogin();

    }

    @Bean
    public PasswordEncoder getEncoder(){
//        return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }
}
