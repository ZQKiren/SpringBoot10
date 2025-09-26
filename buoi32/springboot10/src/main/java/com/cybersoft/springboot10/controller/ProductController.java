package com.cybersoft.springboot10.controller;

import com.cybersoft.springboot10.entity.Products;
import com.cybersoft.springboot10.request.InsertProductRequest;
import com.cybersoft.springboot10.request.UpdateProductRequest;
import com.cybersoft.springboot10.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Products> getAllProducts(){
        return productService.getProduct();
    }

    @PostMapping
    public ResponseEntity<?> insertProduct(@RequestBody InsertProductRequest req){
        return ResponseEntity.ok(productService.insertProduct(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detailProduct(@PathVariable int id){
        return ResponseEntity.of(productService.detailProduct(id));
    }

    @PutMapping
    public ResponseEntity<?> updateProduct(@RequestBody UpdateProductRequest req){
        return ResponseEntity.ok(productService.updateProduct(req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id){
         return ResponseEntity.ok(productService.deleteProduct(id));
    }
}
