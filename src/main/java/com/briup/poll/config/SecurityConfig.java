package com.briup.poll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig{
    @Bean
    public PasswordEncoder passwordEncoder(){
        //使用MD5的加密算法进行加密
        return new BCryptPasswordEncoder();
    }
}