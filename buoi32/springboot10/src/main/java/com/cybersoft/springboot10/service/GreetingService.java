package com.cybersoft.springboot10.service;

import org.springframework.stereotype.Service;


public class GreetingService {

    public String sayHello(String name){
        return "Hello "+name+"!";
    }
}
