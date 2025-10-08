package com.cybersoft.springboot10.service.imp;

import com.cybersoft.springboot10.entity.Categories;
import com.cybersoft.springboot10.entity.Products;
import com.cybersoft.springboot10.repository.CategoryRepository;
import com.cybersoft.springboot10.repository.ProductRepository;
import com.cybersoft.springboot10.request.InsertCategoryRequest;
import com.cybersoft.springboot10.request.InsertProductRequest;
import com.cybersoft.springboot10.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Categories> getCategory(){
        return categoryRepository.findAll();
    }

    @Override
    public String insertCategory(InsertCategoryRequest req){
        Categories categories = new Categories();
        categories.setName(req.getCategoryName());

        categoryRepository.save(categories);

        return "Tạo loại sản phẩm thành công! " + categories.getName();
    }

    @Override
    public List<Products> findProductByCategory(int categoryId){
        return productRepository.findByCategoryId(categoryId);
    }

    @Override
    public ResponseEntity<?> insertProductToCategory(int categoryId, InsertProductRequest req){
        Optional<Categories> categories = categoryRepository.findById(categoryId);
        if(categories.isPresent()){
            Categories categoryEntity = categories.get();
            Products products = new Products();
            products.setName(req.getProductName());
            products.setPrice(req.getProductPrice());
            products.setCategory(categoryEntity);

            productRepository.save(products);
            return ResponseEntity.ok("Thêm sản phẩm thành công! ");
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy loại sản phẩm này!");
    }
}
