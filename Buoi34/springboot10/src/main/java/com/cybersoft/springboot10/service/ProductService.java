package com.cybersoft.springboot10.service;

import com.cybersoft.springboot10.entity.Products;
import com.cybersoft.springboot10.request.InsertProductRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Products> getAll();

    String addProduct(InsertProductRequest req);

    String updateProduct(int productId, InsertProductRequest req);

    Optional<Products> detailProduct(int id);

    ResponseEntity<?> deleteProduct(int id);
}
