package com.cybersoft.springboot10.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TimeService {

    public String getCurrentTime(){
        return LocalDateTime.now().toString();
    }
}
