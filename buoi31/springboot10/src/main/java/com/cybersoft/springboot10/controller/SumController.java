package com.cybersoft.springboot10.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumController {

    @GetMapping("/sum")
    public int sum(int a, int b){
        return a+b;
    }
}
