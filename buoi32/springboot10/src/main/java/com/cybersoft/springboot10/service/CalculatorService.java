package com.cybersoft.springboot10.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int doAdd(int x, int y){
        return x+y;
    }

    public int doSubtract(int x, int y){
        return x-y;
    }

    public int doMultiply(int x, int y){
        return x*y;
    }

    public double doDivide(double x, double y){
        return x/y;
    }
}
