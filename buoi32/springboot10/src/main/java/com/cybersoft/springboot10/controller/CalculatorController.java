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
    public int add(int x, int y){
        return calculatorService.doAdd(x,y);
    }

    @GetMapping("/subtract")
    public int subtract(int x, int y){
        return calculatorService.doSubtract(x,y);
    }

    @GetMapping("/mutiply")
    public int mutiply(int x, int y){
        return calculatorService.doMultiply(x,y);
    }

    @GetMapping("/divide")
    public double divide(int x, int y) throws Exception {
        return calculatorService.doDivide(x,y);
    }
}
