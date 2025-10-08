package com.cybersoft.springboot10.controller;

import com.cybersoft.springboot10.entity.Products;
import com.cybersoft.springboot10.request.InsertProductRequest;
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
        return productService.getAll();
    }

    @PostMapping
    public ResponseEntity<?> insertProducts(@RequestBody InsertProductRequest req){
        return ResponseEntity.ok(productService.addProduct(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detailProducts(@PathVariable int id){
        return ResponseEntity.of(productService.detailProduct(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProducts(@PathVariable int id, @RequestBody InsertProductRequest req){
        return ResponseEntity.ok(productService.updateProduct(id,req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProducts(@PathVariable int id){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
}
