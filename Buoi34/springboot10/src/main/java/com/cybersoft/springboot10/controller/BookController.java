package com.cybersoft.springboot10.controller;

import com.cybersoft.springboot10.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class BookController {

    @Autowired
    private BookService bookService;
    
    @GetMapping
    public ResponseEntity<?> searchBooks(@RequestParam String author){
        return ResponseEntity.ok(bookService.searchBook(author));
    }

    @PostMapping
    public ResponseEntity<?> filterBooks(@RequestParam int minPrice, int maxPrice){
        return ResponseEntity.ok(bookService.filterPrice(minPrice,maxPrice));
    }
}
