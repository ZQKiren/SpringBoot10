package com.cybersoft.springboot10.controller;

import com.cybersoft.springboot10.request.InsertCategoryRequest;
import com.cybersoft.springboot10.request.InsertProductRequest;
import com.cybersoft.springboot10.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getCategories(){
        return ResponseEntity.ok(categoryService.getCategory());
    }

    @PostMapping
    public ResponseEntity<?> insertCategories(@RequestBody InsertCategoryRequest req){
        return ResponseEntity.ok(categoryService.insertCategory(req));
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<?> getProductsToCategories(@PathVariable int id){
        return ResponseEntity.ok(categoryService.findProductByCategory(id));
    }

    @PostMapping("/{id}/products")
    public ResponseEntity<?> insertProductsToCategories(@PathVariable int id, @RequestBody InsertProductRequest req){
        return ResponseEntity.ok(categoryService.insertProductToCategory(id,req));
    }
}
