package com.biratpoudel.springbootpart2.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Hey, Practice Fast Bowling for 15 minutes!!!!";
    }
}
