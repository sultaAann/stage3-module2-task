package com.mjc.school.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"com.mjc.school.service", "com.mjc.school.repository", "com.mjc.school.controller", "com.mjc.school"})
public class Config {
}
