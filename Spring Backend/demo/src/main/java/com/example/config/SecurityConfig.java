package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@SuppressWarnings("SpringJavaAutowiringInspection")
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  
    @Bean
    public CorsFilter corsFilterBean() {
        return new CorsFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .authorizeRequests()
        .anyRequest().permitAll();

        http.addFilterBefore(corsFilterBean(), ChannelProcessingFilter.class);
        http.headers().cacheControl();
    }

}
    
    

