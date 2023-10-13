package com.biratpoudel.springbootpart2.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Hey, Practice your backhand volley";
    }
}
