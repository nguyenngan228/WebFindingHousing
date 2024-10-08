/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.configs;

import com.ndtn.filters.CustomAccessDeniedHandler;
import com.ndtn.filters.JwtAuthenticationTokenFilter;
import com.ndtn.filters.RestAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author thanh
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.ndtn.controllers",
    "com.ndtn.repository",
    "com.ndtn.service",
    "com.ndtn.components"
})
@Order(1)
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() throws Exception {
        JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter();
        jwtAuthenticationTokenFilter.setAuthenticationManager(authenticationManager());
        return jwtAuthenticationTokenFilter;
    }

    @Bean
    public RestAuthenticationEntryPoint restServicesEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/api/**");
        http.authorizeRequests().antMatchers("/api/login/").permitAll();
        http.authorizeRequests().antMatchers("/api/posts/").permitAll();
        http.authorizeRequests().antMatchers("/api/posts/**").permitAll();
        http.authorizeRequests().antMatchers("/api/landlordposts/").permitAll();
        http.authorizeRequests().antMatchers("/api/landlordposts/**").permitAll();
        http.authorizeRequests().antMatchers("/api/district/").permitAll();
        http.authorizeRequests().antMatchers("/api/provine/").permitAll();
        http.authorizeRequests().antMatchers("/api/wards/").permitAll();
        http.authorizeRequests().antMatchers("/api/rooms/**").permitAll();
        http.authorizeRequests().antMatchers("/api/users/**").permitAll();
        http.authorizeRequests().antMatchers("/api/landlord_create/").permitAll();
        http.authorizeRequests().antMatchers("/api/tenantpost/**").permitAll();

//        http.authorizeRequests().antMatchers("/api/users/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/**/comments/").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/**/landlordpost/").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/**/tenantpost/").permitAll();
        http.antMatcher("/api/**").httpBasic().authenticationEntryPoint(restServicesEntryPoint()).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_LANDLORD') or hasRole('ROLE_TENANT')")
                .antMatchers(HttpMethod.POST, "/api/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_LANDLORD') or hasRole('ROLE_TENANT')")
                .antMatchers(HttpMethod.DELETE, "/api/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_LANDLORD') or hasRole('ROLE_TENANT')").and()
                .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
    }
}
