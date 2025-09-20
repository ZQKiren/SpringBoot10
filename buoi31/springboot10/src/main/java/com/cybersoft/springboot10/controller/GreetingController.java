package com.cybersoft.springboot10.controller;

import com.cybersoft.springboot10.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greet")
    public String greet(String name){
        return greetingService.sayHello(name);
    }

    @GetMapping("/welcome/{name}")
    public String welcome(@PathVariable String name, @RequestParam String lang){
        if ("en".equals(lang))
            return "Hello "+name;
        else if ("vi".equals(lang))
            return "Xin chào "+name;
        else
            return "Language is not supported";

    }
}
