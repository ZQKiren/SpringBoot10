package com.cybersoft.springboot10.service;

import com.cybersoft.springboot10.entity.Categories;
import com.cybersoft.springboot10.entity.Products;
import com.cybersoft.springboot10.request.InsertCategoryRequest;
import com.cybersoft.springboot10.request.InsertProductRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    List<Categories> getCategory();

    String insertCategory(InsertCategoryRequest req);

    List<Products> findProductByCategory(int categoryId);

    ResponseEntity<?> insertProductToCategory(int categoryId, InsertProductRequest req);
}
