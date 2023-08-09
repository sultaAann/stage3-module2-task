package com.mjc.school.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan(basePackages = {"com.mjc.school.service", "com.mjc.school.repository", "com.mjc.school.controller", "com.mjc.school"})
public class Config {
    @Bean
    Scanner scanner(){
        return new Scanner(System.in);
    }
}
