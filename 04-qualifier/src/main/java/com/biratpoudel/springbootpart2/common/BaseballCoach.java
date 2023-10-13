package com.biratpoudel.springbootpart2.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Hey, Practice batting for 30 minutes";
    }
}
