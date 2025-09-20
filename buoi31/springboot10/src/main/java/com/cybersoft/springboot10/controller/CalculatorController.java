package com.cybersoft.springboot10.controller;

import com.cybersoft.springboot10.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    public int add(int a, int b){
        return calculatorService.add(a,b);
    }

    @GetMapping("/subtract")
    public int subtract(int a, int b){
        return calculatorService.subtract(a,b);
    }

    @GetMapping("/multiply")
    public int multiply(int a, int b){
        return calculatorService.multiply(a,b);
    }

    @GetMapping("/divide")
    public double divide(int a, int b) throws Exception {
        return calculatorService.divide(a,b);
    }
}
