package com.example.demo2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
   @Bean
    PasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder(12);
   }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("u2")
                .password("$2a$12$uPgsYTObsNJ4epCW4cjase0OK8n1OsjkELJtcGuH1WVXWqLwuhaiO")
                .roles("USER")
                .and()
                .withUser("a2")
                .password("$2a$12$uPgsYTObsNJ4epCW4cjase0OK8n1OsjkELJtcGuH1WVXWqLwuhaiO")
                .roles("ADMIN");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/delete**", "/update**")
                .hasAnyRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
    }
}
