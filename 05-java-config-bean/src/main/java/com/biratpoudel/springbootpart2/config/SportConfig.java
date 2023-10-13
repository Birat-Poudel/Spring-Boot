package com.biratpoudel.springbootpart2.config;

import com.biratpoudel.springbootpart2.common.Coach;
import com.biratpoudel.springbootpart2.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
