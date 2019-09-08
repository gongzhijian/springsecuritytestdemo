package com.example.demo.config;

import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        *//*auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncorder()).withUser("user")
                .password("123456").authorities("PRODUCT_ADD");*//*

    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/product/index").permitAll()
            .antMatchers("/product/add").hasAuthority("PRODUCT_ADD")
            .antMatchers("/product/update").hasAuthority("PRODUCT_UPDATE")
            .antMatchers("/product/list").hasAuthority("PRODUCT_LIST")
            .antMatchers("/product/delete").hasAuthority("PRODUCT_DELETE")
            .antMatchers("/product/test").hasAuthority("PRODUCT_ADD")
            .anyRequest().authenticated()
            .and()
            .formLogin().failureForwardUrl("/index/error");
    }
}
